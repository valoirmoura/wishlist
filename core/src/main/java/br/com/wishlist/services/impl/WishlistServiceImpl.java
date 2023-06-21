package br.com.wishlist.services.impl;

import br.com.wishlist.model.Product;
import br.com.wishlist.model.WishList;
import br.com.wishlist.repositories.ProductRepository;
import br.com.wishlist.repositories.WishListRepository;
import br.com.wishlist.services.WishlistService;
import br.com.wishlist.services.impl.valid.WishlistServiceValid;

import java.time.LocalDateTime;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class WishlistServiceImpl implements WishlistService {

    WishlistServiceValid valid = new WishlistServiceValid();

    private final WishListRepository wishListRepository;
    private final ProductRepository productRepository;

    public WishlistServiceImpl(WishListRepository wishListRepository, ProductRepository productRepository) {
        this.wishListRepository = wishListRepository;
        this.productRepository = productRepository;
    }


    @Override
    public void addToWishList(String customerID, String productID) {
        var wishlist = wishListRepository.getByCustomerID(customerID);
        var prod = productRepository.getByIDProduct(productID);

        if (wishlist != null) {
            valid.addProductToWishlistValid(wishlist, productID);
            wishlist.getProducts().add(prod);
        } else {
            WishList wish = new WishList();
            wish.setCustomerID(customerID);
            wish.getProducts().add(prod);
            wish.setCreatedDate(LocalDateTime.now());
            wishlist = wish;
        }
        wishListRepository.saveWishlist(wishlist);
    }

    @Override
    public void removeFromWishList(String customerID, String productID) {
        var wishlist = wishListRepository.getByCustomerID(customerID);
        var prod = productRepository.getByIDProduct(productID);

        if (wishlist != null) {
            valid.removeProductFromWishlistValid(wishlist, productID);
            wishlist.getProducts().remove(prod);
            wishListRepository.saveWishlist(wishlist);
        }
    }

    @Override
    public List<Product> getAllProductsFromWishlist(String customerID) {
        var wishlist = wishListRepository.getByCustomerID(customerID);

        if (wishlist == null) {
            return List.of();
        }
        return wishlist.getProducts();
    }

    @Override
    public Boolean existProductInWishlist(String customerID, String productID) {
        var wishlist = wishListRepository.getByCustomerID(customerID);
        var prod = productRepository.getByIDProduct(productID);

        return wishlist.getProducts().contains(prod) ? TRUE : FALSE;

    }

}
