package ru.geekmarket.persist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.geekmarket.persist.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findOneByUserName(String userName);

    boolean existsUserByEmail(String email);

    User findUserByEmail(String email);
}
