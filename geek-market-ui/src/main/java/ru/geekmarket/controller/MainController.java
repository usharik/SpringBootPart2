package ru.geekmarket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.geekmarket.controller.repr.CartItemRepr;
import ru.geekmarket.controller.repr.ProductRepr;
import ru.geekmarket.service.CartService;
import ru.geekmarket.service.ProductService;
import ru.geekmarket.service.repr.ProductInfo;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Value("#{'${my.new.property}' + ' hahahah'}")
    private String myNewProperty;

    private final ProductService productService;

    private final CartService cartService;

    @Autowired
    public MainController(ProductService productService, CartService cartService) {
        this.productService = productService;
        this.cartService = cartService;
    }

    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("products", productService.findAll());
        model.addAttribute("cartItems", cartService.findAllItems());
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

    @GetMapping("/store")
    public String storePage(Model model) {
        model.addAttribute("products", productService.findAll());
        return "store";
    }

    @PostMapping("/cart/update")
    public String updateCart(CartItemRepr cartItemRepr, HttpServletRequest httpServletRequest) {
        logger.info("Update customer cart");
        ProductRepr productRepr = productService.findById(cartItemRepr.getProductId());

        if (productRepr != null) {
            cartService.addItemQty(new ProductInfo(productRepr, "", ""), cartItemRepr.getQty());
        }
        return "redirect:" + cartItemRepr.getPageUrl();
    }
}
