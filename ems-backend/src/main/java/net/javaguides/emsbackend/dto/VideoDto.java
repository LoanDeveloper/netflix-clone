package net.javaguides.emsbackend.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class VideoDto {
    private int id;
    private String title;
    private String description;
    private String thumbnailUrl;
    private String videoUrl;
    private Integer duration;
    private Integer views;
    private LocalDate releaseDate;
    private LocalDateTime createdAt;

    // Constructeurs
    public VideoDto() {}

    public VideoDto(int id, String title, String description, String thumbnailUrl, 
                   String videoUrl, Integer duration, Integer views, 
                   LocalDate releaseDate, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
        this.videoUrl = videoUrl;
        this.duration = duration;
        this.views = views;
        this.releaseDate = releaseDate;
        this.createdAt = createdAt;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
