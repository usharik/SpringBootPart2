package ru.geekmarket.flow;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.geekmarket.flow.register.UserRegisterHandler;
import ru.geekmarket.service.UserService;

@Configuration
public class FlowHandlersConfiguration {

    @Bean
    public UserRegisterHandler userRegisterHandler(UserService userService) {
        return new UserRegisterHandler(userService);
    }
}
