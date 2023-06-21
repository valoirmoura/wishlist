package br.com.wishlist.exception;

public class WishlistException extends RuntimeException{
    public WishlistException() {
    }

    public WishlistException(String message) {
        super(message);
    }
}
