package ru.geekmarket.persist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekmarket.persist.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
