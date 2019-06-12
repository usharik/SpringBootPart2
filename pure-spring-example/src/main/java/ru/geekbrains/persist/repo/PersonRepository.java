package ru.geekbrains.persist.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.persist.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
