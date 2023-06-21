package br.com.wishlist.document;

import br.com.wishlist.model.Product;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "wishlist")
public class WishlistDocument {

    @Id
    private String customerID;
    private List<Product> products;
    private LocalDateTime createdDate;

    public WishlistDocument() {
    }

    public WishlistDocument(String customerID, List<Product> products, LocalDateTime createdDate) {
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
