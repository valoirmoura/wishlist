package br.com.wishlist.repositories;

import br.com.wishlist.model.Product;

import java.util.List;

public interface ProductRepository {

    void saveProduct(Product product);

    List<Product> getAllProduct();

    Product getByIDProduct(String productID);

    void removeProduct(String productID);

}
