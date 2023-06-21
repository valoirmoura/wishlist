package br.com.wishlist.services.impl;

import br.com.wishlist.model.Product;
import br.com.wishlist.repositories.ProductRepository;
import br.com.wishlist.services.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.saveProduct(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.getAllProduct();
    }

    @Override
    public Product getByIDProduct(String productID) {
        return productRepository.getByIDProduct(productID);
    }

    @Override
    public void removeProduct(String productID) {
        productRepository.removeProduct(productID);

    }

}
