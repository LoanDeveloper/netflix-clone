package net.javaguides.emsbackend.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.emsbackend.dto.VideoDto;
import net.javaguides.emsbackend.entity.Video;
import net.javaguides.emsbackend.mapper.VideoMapper;
import net.javaguides.emsbackend.repository.VideoRepository;
import net.javaguides.emsbackend.service.VideoService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VideoServiceImpl implements VideoService {

    private VideoRepository videoRepository;

    @Override
    public VideoDto createVideo(VideoDto videoDto) {

        Video video = VideoMapper.mapToVideo(videoDto);
        Video savedVideo = videoRepository.save(video);

        return VideoMapper.mapToVideoDto(savedVideo);
    }
}
