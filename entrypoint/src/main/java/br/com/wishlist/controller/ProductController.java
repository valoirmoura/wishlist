package br.com.wishlist.controller;

import br.com.wishlist.model.Product;
import br.com.wishlist.request.ProductRequest;
import br.com.wishlist.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "products")
public class ProductController {
    private final ModelMapper modelMapper;
    private final ProductService productService;

    public ProductController(ModelMapper modelMapper, ProductService productService) {
        this.modelMapper = modelMapper;
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ProductRequest request) {
        var product = modelMapper.map(request, Product.class);
        this.productService.saveProduct(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping
    public List<Product> getAll() {
        List<Product> products = productService.getAllProduct();
        return ResponseEntity.ok().body(products).getBody();
    }

    @GetMapping("/{productID}")
    public Product getProductByID(@PathVariable String productID) {
        var prod = productService.getByIDProduct(productID);
        return ResponseEntity.ok().body(prod).getBody();
    }

    @DeleteMapping("/{productID}")
    public ResponseEntity<?> removeProductByID(@PathVariable String productID) {
        productService.removeProduct(productID);
        return ResponseEntity.noContent().build();
    }
}
