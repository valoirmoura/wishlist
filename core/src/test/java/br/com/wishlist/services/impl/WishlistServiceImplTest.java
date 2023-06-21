package br.com.wishlist.services.impl;

import br.com.wishlist.model.Customer;
import br.com.wishlist.model.Product;
import br.com.wishlist.repositories.ProductRepository;
import br.com.wishlist.repositories.WishListRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class WishlistServiceImplTest {

    @InjectMocks
    private WishlistServiceImpl wishlistService;

    @Mock
    private WishListRepository wishListRepository;

    @Mock
    private ProductRepository productRepository;

    private Product product;
    private Customer customer;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startObjects();
    }

    @Test
    void addToWishList() {
    }

    @Test
    void removeFromWishList() {
    }

    @Test
    void getAllProductsFromWishlist() {
    }

    @Test
    void existProductInWishlist() {
    }


    public void startObjects() {
        product = new Product("TESTE1", "Cello", "Instrumento Musical", "Cordas");
        customer = new Customer("TESTE1", "Anderson", "Silva", "anderson.silva@mail.com", "123456");
    }
}