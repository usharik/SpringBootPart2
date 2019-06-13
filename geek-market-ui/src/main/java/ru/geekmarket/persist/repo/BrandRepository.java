package ru.geekmarket.persist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekmarket.persist.model.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
