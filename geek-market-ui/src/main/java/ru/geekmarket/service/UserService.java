package ru.geekmarket.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.geekmarket.service.model.SystemUser;

import java.util.List;

public interface UserService extends UserDetailsService {

    SystemUser findById(Long id);

    SystemUser findByUserName(String username);

    boolean save(SystemUser systemUser);

    List<SystemUser> findAll();
}