package net.javaguides.emsbackend.service;

import net.javaguides.emsbackend.dto.VideoDto;

public interface VideoService {
    VideoDto createVideo(VideoDto videoDto);

    VideoDto getVideoById(Integer id);
}
