package net.javaguides.emsbackend.repository;

import net.javaguides.emsbackend.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Integer> {
}
