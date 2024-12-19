package net.javaguides.emsbackend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.emsbackend.dto.VideoDto;
import net.javaguides.emsbackend.service.VideoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/videos")
public class VideoController {

    private VideoService videoService;

    // Build Add Video REST API
    @PostMapping
    public ResponseEntity<VideoDto> createVideo(@RequestBody VideoDto videoDto) {
        VideoDto savedVideo = videoService.createVideo(videoDto);
        return new ResponseEntity<>(savedVideo, HttpStatus.CREATED);
    }
}
