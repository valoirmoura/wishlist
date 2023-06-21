package br.com.wishlist.dao.impl;

import br.com.wishlist.dao.ProductDAO;
import br.com.wishlist.document.ProductDocument;
import br.com.wishlist.model.Product;
import br.com.wishlist.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductDAO productDAO;
    private final ModelMapper modelMapper;

    public ProductRepositoryImpl(ProductDAO productDAO, ModelMapper modelMapper) {
        this.productDAO = productDAO;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveProduct(Product product) {
        ProductDocument prodDoc = modelMapper.map(product, ProductDocument.class);
        productDAO.insert(prodDoc);
    }

    @Override
    public List<Product> getAllProduct() {
        List<ProductDocument> prods = productDAO.findAll();
        return prods.stream()
                .map(prod -> modelMapper.map(prod, Product.class))
                .toList();
    }

    @Override
    public Product getByIDProduct(String productID) {
        Optional<ProductDocument> prodDoc = productDAO.findById(productID);
        return modelMapper.map(prodDoc, Product.class);
    }

    @Override
    public void removeProduct(String productID) {
        Optional<ProductDocument> prod = productDAO.findById(productID);
        productDAO.delete(prod.get());
    }
}
