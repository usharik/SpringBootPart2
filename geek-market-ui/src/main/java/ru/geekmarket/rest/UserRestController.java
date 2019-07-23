package ru.geekmarket.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekmarket.service.UserService;
import ru.geekmarket.service.repr.SystemUser;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api")
@RestController
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(@Lazy UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<String> allUsers() {
        return userService.findAll().stream().map(SystemUser::getUserName).collect(Collectors.toList());
    }
}
