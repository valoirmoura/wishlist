package br.com.wishlist.dao;

import br.com.wishlist.document.ProductDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductDAO extends MongoRepository<ProductDocument, String> {
}
