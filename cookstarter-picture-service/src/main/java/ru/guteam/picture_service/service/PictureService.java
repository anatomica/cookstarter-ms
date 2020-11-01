package ru.guteam.picture_service.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.guteam.picture_service.model.Picture;
import ru.guteam.picture_service.repo.PictureRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class PictureService {
    @Value("${app.name-length}")
    private int nameLength;
    private final PictureRepository pictureRepository;

    @Autowired
    public PictureService(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    public void getPicture(Long id, HttpServletResponse response) throws IOException {
        Optional<Picture> picture = pictureRepository.findById(id);
        if (picture.isPresent()) {
            Path image = Paths.get(picture.get().getPath());
            byte[] bytes = Files.readAllBytes(image);
            response.setContentType("image");
            response.getOutputStream().write(bytes);
        }
    }

    @Transactional
    public void deletePicture(Long id) throws IOException {
        Optional<Picture> oldFile = pictureRepository.findById(id);
        if (oldFile.isPresent()) {
            Path oldPic = Paths.get(oldFile.get().getPath());
            Files.delete(oldPic);
        }
        pictureRepository.deleteById(id);
    }

    @Transactional
    public Long insert(MultipartFile multipartFile) throws IOException {
        Path root = Paths.get("Pictures");
        String name = RandomStringUtils.randomAlphanumeric(nameLength) + "." + FilenameUtils.getExtension(multipartFile.getOriginalFilename());
        Path picFile = Paths.get(root.toString(), name);
        Files.copy(multipartFile.getInputStream(), root.resolve(Objects.requireNonNull(name)));
        Picture picture = Picture.builder()
                .path(picFile.toAbsolutePath().toString())
                .build();
        pictureRepository.save(picture);
        return picture.getId();
    }

    @Transactional
    public void update(MultipartFile multipartFile, Long pictureId) throws IOException {
        Path root = Paths.get("Pictures");
        String name = RandomStringUtils.randomAlphanumeric(nameLength) + "." + FilenameUtils.getExtension(multipartFile.getOriginalFilename());
        Path picFile = Paths.get(root.toString(), name);
        Optional<Picture> oldFile = pictureRepository.findById(pictureId);
        if (oldFile.isPresent()) {
            Path oldPic = Paths.get(oldFile.get().getPath());
            Files.delete(oldPic);
        }
        Files.copy(multipartFile.getInputStream(), root.resolve(Objects.requireNonNull(name)));
        Picture picture = Picture.builder()
                .id(pictureId)
                .path(picFile.toAbsolutePath().toString())
                .build();
        pictureRepository.save(picture);
    }
}
