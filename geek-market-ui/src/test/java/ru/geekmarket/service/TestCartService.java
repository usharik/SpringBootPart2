package ru.geekmarket.service;

import org.junit.Before;
import org.junit.Test;
import ru.geekmarket.controller.repr.ProductRepr;
import ru.geekmarket.service.repr.ProductInfo;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TestCartService {

    private CartService cartService;

    @Before
    public void init() {
        cartService = new CartServiceImpl();
    }

    @Test
    public void testAddOneProduct() {
        ProductRepr expectedProduct = new ProductRepr();
        expectedProduct.setId(1L);
        expectedProduct.setPrice(new BigDecimal(111));
        expectedProduct.setName("Product name");

        ProductInfo expectedProductInfo = new ProductInfo();
        expectedProductInfo.setSize("size");
        expectedProductInfo.setColor("color");
        expectedProductInfo.setProduct(expectedProduct);

        cartService.addItemQty(expectedProductInfo, 1);

        Map<ProductInfo, Integer> allItems = cartService.findAllItems();
        assertEquals(allItems.size(), 1);
        assertEquals(1, (long) allItems.get(expectedProductInfo));
        assertEquals(1, (long) cartService.getItemsQty());
        assertEquals(new BigDecimal(111), cartService.getSubTotal());
    }

}
