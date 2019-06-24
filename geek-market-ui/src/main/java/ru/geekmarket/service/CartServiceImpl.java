package ru.geekmarket.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekmarket.service.repr.ProductInfo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CartServiceImpl implements CartService {

    private static final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);

    private Map<ProductInfo, Integer> cartItems;

    public CartServiceImpl() {
        cartItems = new ConcurrentHashMap<>();
    }

    @Override
    public void addItemQty(ProductInfo prodInfo, int qty) {
        cartItems.put(prodInfo, cartItems.getOrDefault(prodInfo, 0) + qty);
    }

    @Override
    public void removeItemQty(ProductInfo prodInfo, int qty) {
        int currentQty = cartItems.getOrDefault(prodInfo, 0);
        if (currentQty - qty > 0) {
            cartItems.put(prodInfo, currentQty - qty);
        } else {
            cartItems.remove(prodInfo);
        }
    }

    @Override
    public void removeItem(ProductInfo productInfo) {
        cartItems.remove(productInfo);
    }

    @Override
    public Map<ProductInfo, Integer> findAllItems() {
        return Collections.unmodifiableMap(cartItems);
    }

    @Override
    public Integer getItemsQty() {
        return cartItems.size();
    }

    @Override
    public BigDecimal getSubTotal() {
        return cartItems.entrySet().stream()
                .map(e -> e.getKey().getProduct().getPrice().multiply(new BigDecimal(e.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private long created;

    @PostConstruct
    public void postConstruct() {
        created = System.currentTimeMillis();
        logger.info("Session bean created");
    }

    @PreDestroy
    public void preDestroy() {
        logger.info("Session bean destroyed {}", (System.currentTimeMillis() - created));
    }
}
