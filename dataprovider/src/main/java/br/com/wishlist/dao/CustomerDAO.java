package br.com.wishlist.dao;

import br.com.wishlist.document.CustomerDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerDAO extends MongoRepository<CustomerDocument, String> {
}
