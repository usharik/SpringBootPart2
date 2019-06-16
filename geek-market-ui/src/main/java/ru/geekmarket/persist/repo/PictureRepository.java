package ru.geekmarket.persist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekmarket.persist.model.Picture;

public interface PictureRepository extends JpaRepository<Picture, Long> {
}
