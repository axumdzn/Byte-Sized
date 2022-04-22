package com.bytesize.entities;

import java.util.List;
import java.util.Objects;

public class Product {
    private int productId;
    private String title;
    private String description;
    private float price;
    private int inventory;
    private List<String> sizes;
    private int sellerId;

    public Product(){}

    public Product(int productId, String title, String description, float price, int inventory, int sellerId){
        this.productId=productId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.inventory = inventory;
        this.sellerId = sellerId;
    }

    public Product(int productId, String title, String description, float price){
        this.productId=productId;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public List<String> getSizes() {
        return sizes;
    }

    public void setSizes(List<String> sizes) {
        this.sizes = sizes;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId && Float.compare(product.price, price) == 0 && inventory == product.inventory && sellerId == product.sellerId && Objects.equals(title, product.title) && Objects.equals(description, product.description) && Objects.equals(sizes, product.sizes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, title, description, price, inventory, sizes, sellerId);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", inventory=" + inventory +
                ", sizes=" + sizes +
                ", sellerId=" + sellerId +
                '}';
    }
}
