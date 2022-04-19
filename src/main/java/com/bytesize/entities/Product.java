package com.bytesize.entities;

import java.util.Objects;

public class Product {
    private int productId, seller_id, inventory;
    private String title, description ;
    private float price;

    public Product(int productId, String title, float price, int inventory, String description, int seller_id) {
        this.productId = productId;
        this.title = title;
        this.price = price;
        this.inventory = inventory;
        this.description = description;
        this.seller_id = seller_id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(int seller_id) {
        seller_id = seller_id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId && Float.compare(product.price, price) == 0 && inventory == product.inventory && seller_id == product.seller_id && Objects.equals(title, product.title) && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, title, price, inventory, description, seller_id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", Title='" + title + '\'' +
                ", price=" + price +
                ", inventory=" + inventory +
                ", description='" + description + '\'' +
                ", Seller_id=" + seller_id +
                '}';
    }
}
