package net.javaguides.emsbackend.mapper;

import net.javaguides.emsbackend.dto.VideoDto;
import net.javaguides.emsbackend.entity.Video;

public class VideoMapper {

    public static VideoDto mapToVideoDto(Video video) {
        return new VideoDto(
                video.getId(),
                video.getTitle(),
                video.getDescription(),
                video.getThumbnailUrl(),
                video.getVideoUrl(),
                video.getDuration(),
                video.getViews(),
                video.getPublishedDate(),
                video.getCreatedAt(),
                video.getType()
                );
    }

    public static Video mapToVideo(VideoDto videoDto) {
        return new Video(
                videoDto.getId(),
                videoDto.getTitle(),
                videoDto.getDescription(),
                videoDto.getThumbnailUrl(),
                videoDto.getVideoUrl(),
                videoDto.getDuration(),
                videoDto.getViews(),
                videoDto.getReleaseDate(),
                videoDto.getCreatedAt(),
                videoDto.getType()
        );
    }
}
