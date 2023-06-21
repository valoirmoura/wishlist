package br.com.wishlist.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class ProductDocument {

    @Id
    private String productID;
    private String name;
    private String description;
    private String category;

    public ProductDocument() {
    }

    public ProductDocument(String productID, String name, String description, String category) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public ProductDocument(String name, String description, String category) {
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
