package net.javaguides.emsbackend.repository;

import net.javaguides.emsbackend.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {
    List<Video> findByType(String type);
}
