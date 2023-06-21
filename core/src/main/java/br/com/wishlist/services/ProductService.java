package br.com.wishlist.services;

import br.com.wishlist.model.Product;

import java.util.List;

public interface ProductService {

    void saveProduct(Product product);

    List<Product> getAllProduct();

    Product getByIDProduct(String productID);

    void removeProduct(String productID);

}
