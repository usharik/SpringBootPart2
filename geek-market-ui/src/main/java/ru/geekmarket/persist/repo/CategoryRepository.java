package ru.geekmarket.persist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekmarket.persist.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
