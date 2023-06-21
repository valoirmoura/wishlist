package br.com.wishlist.services.impl.valid;

import br.com.wishlist.exception.WishlistException;
import br.com.wishlist.model.WishList;

public class WishlistServiceValid {

    public static final int WISHLIST_SIZE = 20;
    public static final String WISHLIST_SIZE_EXCEEDED = "Wishlist size exceeded!";
    public static final String WISHLIST_EXIST_PRODUCT = "Wishlist exist product!";
    public static final String PRODUCT_NOT_INCLUDED_WISHLIST = "Product not included Wishlist!";


    public void addProductToWishlistValid(WishList wishlist, String productID) {
        if (wishlist.getProducts().size() >= WISHLIST_SIZE) {
            throw new WishlistException(WISHLIST_SIZE_EXCEEDED);
        }
        wishlist.getProducts()
                .forEach(prod -> {
                    if (prod.getProductID().equals(productID))
                        throw new WishlistException(WISHLIST_EXIST_PRODUCT);
                });
    }

    public void removeProductFromWishlistValid(WishList wishList, String productID) {
        wishList.getProducts()
                .forEach(prod -> {
                    if (!prod.getProductID().equals(productID)) {
                        throw new WishlistException(PRODUCT_NOT_INCLUDED_WISHLIST);
                    }
                });
    }

}
