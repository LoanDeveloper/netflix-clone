package net.javaguides.emsbackend.controller;

import net.javaguides.emsbackend.dto.VideoDto;
import net.javaguides.emsbackend.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/videos")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/sync/tmdb")
    public ResponseEntity<List<VideoDto>> fetchAndSaveTMDBMovies() {
        List<VideoDto> savedVideos = videoService.fetchAndSaveMoviesFromTMDB();
        return new ResponseEntity<>(savedVideos, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<VideoDto>> getAllVideos() {
        List<VideoDto> videos = videoService.getAllVideos();
        return ResponseEntity.ok(videos);
    }

    @GetMapping("/movies")
    public ResponseEntity<List<VideoDto>> getMovies() {
        List<VideoDto> movies = videoService.getMovies();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/series")
    public ResponseEntity<List<VideoDto>> getSeries() {
        List<VideoDto> series = videoService.getSeries();
        return ResponseEntity.ok(series);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VideoDto> getVideoById(@PathVariable("id") Integer videoId) {
        VideoDto videoDto = videoService.getVideoById(videoId);
        return ResponseEntity.ok(videoDto);
    }

    @PostMapping
    public ResponseEntity<VideoDto> createVideo(@RequestBody VideoDto videoDto) {
        VideoDto savedVideo = videoService.createVideo(videoDto);
        return new ResponseEntity<>(savedVideo, HttpStatus.CREATED);
    }
}
