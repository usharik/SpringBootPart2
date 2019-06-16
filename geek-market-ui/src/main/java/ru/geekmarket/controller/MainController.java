package ru.geekmarket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.geekmarket.service.ProductService;

@Controller
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    private final ProductService productService;

    @Autowired
    public MainController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("products", productService.findAll());
        return "index";
    }

    @GetMapping("/cart")
    public String cartPage() {
        return "cart";
    }

    @GetMapping("/checkout")
    public String checkoutPage() {
        return "checkout";
    }

    @GetMapping("/product/{id}")
    public String productPage(Model model, @PathVariable("id") Long id) {
        logger.info("Product {} page", id);
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("products", productService.findAll());
        return "product";
    }

    @GetMapping("/store")
    public String storePage(Model model) {
        model.addAttribute("products", productService.findAll());
        return "store";
    }
}
