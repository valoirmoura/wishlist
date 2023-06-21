package br.com.wishlist.model;

import java.util.UUID;

public class Product {

    private String productID;
    private String name;
    private String description;
    private String category;

    public Product() {
    }

    public Product(String productID, String name, String description, String category) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public Product(String name, String description, String category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
