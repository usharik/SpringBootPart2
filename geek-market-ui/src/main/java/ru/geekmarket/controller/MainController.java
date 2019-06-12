package ru.geekmarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/checkout")
    public String checkoutPage() {
        return "checkout";
    }

    @GetMapping("/product")
    public String productPage() {
        return "product";
    }

    @GetMapping("/store")
    public String storePage() {
        return "store";
    }
}
