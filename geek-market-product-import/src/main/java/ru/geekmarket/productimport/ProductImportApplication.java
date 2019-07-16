package ru.geekmarket.productimport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.config.EnableIntegration;

@EnableIntegration
@IntegrationComponentScan
//@ImportResource("classpath:file-move-integration.xml")
@SpringBootApplication
public class ProductImportApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductImportApplication.class, args);
    }

}
