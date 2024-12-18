package net.javaguides.emsbackend.mapper;

import net.javaguides.emsbackend.dto.VideoDto;
import net.javaguides.emsbackend.entity.Video;

public class VideoMapper {

    public static VideoDto mapToVideoDto(Video video) {
        return new VideoDto(
                video.getId(),
                video.getDescription(),
                video.getTitle(),
                video.getThumbnailUrl(),
                video.getVideoUrl(),
                video.getDuration(),
                video.getViews(),
                video.getPublishedDate(),
                video.getCreatedAt()
                );
    }

    public static Video mapToVideo(VideoDto videoDto) {
        return new Video(
                videoDto.getId(),
                videoDto.getDescription(),
                videoDto.getTitle(),
                videoDto.getThumbnailUrl(),
                videoDto.getVideoUrl(),
                videoDto.getDuration(),
                videoDto.getViews(),
                videoDto.getReleaseDate(),
                videoDto.getCreatedAt()
        );
    }
}
