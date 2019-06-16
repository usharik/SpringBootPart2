package ru.geekmarket.controller.repr;

public class CategoryRepr {

    private long id;

    private String name;

    private long productCount;

    public CategoryRepr(long id, String name, long productCount) {
        this.id = id;
        this.name = name;
        this.productCount = productCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getProductCount() {
        return productCount;
    }

    public void setProductCount(long productCount) {
        this.productCount = productCount;
    }
}
