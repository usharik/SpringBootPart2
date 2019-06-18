package ru.geekmarket.controller.repr;

import org.springframework.web.multipart.MultipartFile;
import ru.geekmarket.persist.model.Brand;
import ru.geekmarket.persist.model.Category;
import ru.geekmarket.persist.model.Picture;
import ru.geekmarket.persist.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductRepr {

    private Long id;

    private String name;

    private BigDecimal price;

    private Set<Category> categories;

    private Brand brand;

    private List<Picture> pictures;

    private MultipartFile[] newPictures;

    public ProductRepr() {
    }

    public ProductRepr(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.categories = product.getCategories();
        this.brand = product.getBrand();
        this.pictures = product.getPictures();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public String getCategoriesAsString() {
        return getCategories()
                .stream()
                .map(Category::getName)
                .collect(Collectors.joining(", "));
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public MultipartFile[] getNewPictures() {
        return newPictures;
    }

    public void setNewPictures(MultipartFile[] newPictures) {
        this.newPictures = newPictures;
    }
}
