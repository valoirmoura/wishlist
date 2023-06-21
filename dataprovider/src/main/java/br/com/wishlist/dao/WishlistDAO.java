package br.com.wishlist.dao;

import br.com.wishlist.document.WishlistDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WishlistDAO extends MongoRepository<WishlistDocument, String> {
}
