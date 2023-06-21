package br.com.wishlist.repositories;

import br.com.wishlist.model.WishList;

import java.util.List;

public interface WishListRepository {

    void saveWishlist(WishList wishList);

    WishList getByCustomerID(String customerID);

    List<WishList> getAllWishlist();

    void deleteWishlist(String customerID);


}
