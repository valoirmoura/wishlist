package br.com.wishlist.services;

import br.com.wishlist.model.Product;

import java.util.List;

public interface WishlistService {

    void addToWishList(String customerID, String productID);

    void removeFromWishList(String customerID, String productID);

    List<Product> getAllProductsFromWishlist(String customerID);

    Boolean existProductInWishlist(String customerID, String productID);
}
