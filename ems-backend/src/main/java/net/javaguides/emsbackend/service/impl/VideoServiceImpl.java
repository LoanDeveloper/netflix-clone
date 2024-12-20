package net.javaguides.emsbackend.service.impl;

import net.javaguides.emsbackend.dto.VideoDto;
import net.javaguides.emsbackend.entity.Video;
import net.javaguides.emsbackend.expection.ResourceNotFoundException;
import net.javaguides.emsbackend.mapper.VideoMapper;
import net.javaguides.emsbackend.repository.VideoRepository;
import net.javaguides.emsbackend.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService {
    
    @Autowired
    private VideoRepository videoRepository;

    @Override
    public VideoDto createVideo(VideoDto videoDto) {
        Video video = VideoMapper.mapToVideo(videoDto);
        Video savedVideo = videoRepository.save(video);
        return VideoMapper.mapToVideoDto(savedVideo);
    }

    @Override
    public VideoDto getVideoById(Integer videoId) {
        Video video = videoRepository.findById(videoId)
                .orElseThrow(() -> new ResourceNotFoundException("Video is not exist with given id : " + videoId));
        return VideoMapper.mapToVideoDto(video);
    }
}
