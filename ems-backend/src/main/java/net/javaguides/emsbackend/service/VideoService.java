package net.javaguides.emsbackend.service;

import net.javaguides.emsbackend.dto.VideoDto;
import java.util.List;

public interface VideoService {
    VideoDto createVideo(VideoDto videoDto);

    VideoDto getVideoById(Integer id);

    List<VideoDto> fetchAndSaveMoviesFromTMDB();

    List<VideoDto> getAllVideos();

    List<VideoDto> getMovies();

    List<VideoDto> getSeries();
}
