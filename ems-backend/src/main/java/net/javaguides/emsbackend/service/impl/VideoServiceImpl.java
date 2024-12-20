package net.javaguides.emsbackend.service.impl;

import net.javaguides.emsbackend.dto.VideoDto;
import net.javaguides.emsbackend.entity.Video;
import net.javaguides.emsbackend.expection.ResourceNotFoundException;
import net.javaguides.emsbackend.mapper.VideoMapper;
import net.javaguides.emsbackend.repository.VideoRepository;
import net.javaguides.emsbackend.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VideoServiceImpl implements VideoService {
    
    @Autowired
    private VideoRepository videoRepository;
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Value("${tmdb.api.key}")
    private String apiKey;
    
    private static final String TMDB_BASE_URL = "https://api.themoviedb.org/3";

    @Override
    public List<VideoDto> fetchAndSaveMoviesFromTMDB() {
        try {
            String url = "https://api.themoviedb.org/3/trending/all/day?api_key=" + apiKey;
            RestTemplate restTemplate = new RestTemplate();
            Map<String, Object> response = restTemplate.getForObject(url, Map.class);
            
            if (response == null || !response.containsKey("results")) {
                throw new IllegalStateException("Réponse TMDB invalide");
            }

            List<Map<String, Object>> results = (List<Map<String, Object>>) response.get("results");
            
            return results.stream()
                    .map(this::convertToVideoDto)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .map(this::createVideo)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la récupération des films TMDB", e);
        }
    }

    private Optional<VideoDto> convertToVideoDto(Map<String, Object> tmdbData) {
        try {
            VideoDto videoDto = new VideoDto();
            
            // Vérification des données obligatoires
            String title = (String) tmdbData.get("title");
            if (title == null) {
                title = (String) tmdbData.get("name"); // Pour les séries TV
            }
            if (title == null) {
                return Optional.empty();
            }
            
            videoDto.setTitle(title);
            videoDto.setDescription((String) tmdbData.getOrDefault("overview", "Pas de description disponible"));
            
            // URL vidéo par défaut basée sur l'ID TMDB
            String tmdbId = String.valueOf(tmdbData.get("id"));
            videoDto.setVideoUrl("https://www.themoviedb.org/movie/" + tmdbId);
            
            // Thumbnail
            String posterPath = (String) tmdbData.get("poster_path");
            videoDto.setThumbnailUrl(posterPath != null 
                ? "https://image.tmdb.org/t/p/w500" + posterPath 
                : "https://via.placeholder.com/500x750");
            
            // Date de publication
            try {
                String releaseDate = (String) tmdbData.getOrDefault("release_date", 
                    tmdbData.getOrDefault("first_air_date", null));
                videoDto.setPublishedDate(releaseDate != null 
                    ? LocalDate.parse(releaseDate) 
                    : LocalDate.now());
            } catch (Exception e) {
                videoDto.setPublishedDate(LocalDate.now());
            }
            
            videoDto.setViews(((Number) tmdbData.getOrDefault("vote_count", 0)).intValue());
            videoDto.setDuration(120);
            videoDto.setType((String) tmdbData.getOrDefault("media_type", "movie"));
            videoDto.setCreatedAt(LocalDateTime.now());
            
            return Optional.of(videoDto);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public VideoDto createVideo(VideoDto videoDto) {
        Video video = VideoMapper.mapToVideo(videoDto);
        Video savedVideo = videoRepository.save(video);
        return VideoMapper.mapToVideoDto(savedVideo);
    }

    @Override
    public List<VideoDto> getAllVideos() {
        List<Video> videos = videoRepository.findAll();
        return videos.stream()
                .map(VideoMapper::mapToVideoDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<VideoDto> getMovies() {
        return videoRepository.findByType("movie")
                .stream()
                .map(VideoMapper::mapToVideoDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<VideoDto> getSeries() {
        return videoRepository.findByType("tv")
                .stream()
                .map(VideoMapper::mapToVideoDto)
                .collect(Collectors.toList());
    }

    @Override
    public VideoDto getVideoById(Integer videoId) {
        Video video = videoRepository.findById(videoId)
                .orElseThrow(() -> new ResourceNotFoundException("Video is not exist with given id : " + videoId));
        return VideoMapper.mapToVideoDto(video);
    }
}
