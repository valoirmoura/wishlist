package br.com.wishlist.model;

import java.time.LocalDateTime;
import java.util.List;

public class WishList {

    private String customerID;
    private List<Product> products;
    private LocalDateTime createdDate;

    public WishList() {
    }

    public WishList(String customerID, List<Product> products, LocalDateTime createdDate) {
        this.customerID = customerID;
        this.products = products;
        this.createdDate = createdDate;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
