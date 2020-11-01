package ru.guteam.picture_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.guteam.picture_service.model.Picture;

public interface PictureRepository extends JpaRepository<Picture, Long> {
    Picture findByPath(String path);
}
