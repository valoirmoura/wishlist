package br.com.wishlist.controller;

import br.com.wishlist.request.ProductRequest;
import br.com.wishlist.services.WishlistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {

    private final WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @PostMapping("/{customerID}")
    public ResponseEntity<?> addToWishList(@PathVariable String customerID,
                                           @RequestBody String productID) {
        wishlistService.addToWishList(customerID, productID);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{customerID}")
    public ResponseEntity<?> removeFromWishList(@PathVariable String customerID,
                                                @RequestBody String productID) {
        wishlistService.removeFromWishList(customerID, productID);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/{customerID}")
    public ResponseEntity<ProductRequest> getAllProductsFromWishlist(@PathVariable String customerID) {
        var prods = wishlistService.getAllProductsFromWishlist(customerID);
        return ResponseEntity.ok((ProductRequest) prods);

    }

    @GetMapping("/{consumerID}/exist/{productID}")
    public ResponseEntity<Boolean> existProductInWishlist(@PathVariable String consumerID,
                                                          @PathVariable String productID) {
        var existProd = wishlistService.existProductInWishlist(consumerID, productID);
        return ResponseEntity.ok(existProd);
    }
}
