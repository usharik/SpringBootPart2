package ru.geekmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GeekMarketUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeekMarketUiApplication.class, args);
    }

}
