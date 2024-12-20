package net.javaguides.emsbackend.controller;

import net.javaguides.emsbackend.dto.VideoDto;
import net.javaguides.emsbackend.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/videos")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @PostMapping
    public ResponseEntity<VideoDto> createVideo(@RequestBody VideoDto videoDto) {
        VideoDto savedVideo = videoService.createVideo(videoDto);
        return new ResponseEntity<>(savedVideo, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VideoDto> getVideoById(@PathVariable("id") Integer videoId) {
        VideoDto videoDto = videoService.getVideoById(videoId);
        return ResponseEntity.ok(videoDto);
    }
}
