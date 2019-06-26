package ru.geekmarket.flow;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.geekmarket.flow.register.UserRegisterHandler;

@Configuration
public class FlowHandlersConfiguration {

    @Bean
    public UserRegisterHandler userRegisterHandler() {
        return new UserRegisterHandler();
    }
}
