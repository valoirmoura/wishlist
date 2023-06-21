package br.com.wishlist.dao.impl;

import br.com.wishlist.dao.WishlistDAO;
import br.com.wishlist.document.WishlistDocument;
import br.com.wishlist.model.WishList;
import br.com.wishlist.repositories.WishListRepository;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

public class WishlistRepositoryImpl implements WishListRepository {

    private final WishlistDAO wishlistDAO;
    private final ModelMapper modelMapper;

    public WishlistRepositoryImpl(WishlistDAO wishlistDAO, ModelMapper modelMapper) {
        this.wishlistDAO = wishlistDAO;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveWishlist(WishList wishList) {
        WishlistDocument wishDoc = modelMapper.map(wishList, WishlistDocument.class);
        wishlistDAO.insert(wishDoc);

    }

    @Override
    public WishList getByCustomerID(String customerID) {
        Optional<WishlistDocument> wishlistFromCustomer = wishlistDAO.findById(customerID);
        return modelMapper.map(wishlistFromCustomer, WishList.class);
    }

    @Override
    public List<WishList> getAllWishlist() {
        List<WishlistDocument> wishlists = wishlistDAO.findAll();
        return wishlists.stream()
                .map(wishlist -> modelMapper.map(wishlist, WishList.class))
                .toList();
    }

    @Override
    public void deleteWishlist(String customerID) {
        Optional<WishlistDocument> wishlistFromCustomer = wishlistDAO.findById(customerID);
        wishlistDAO.delete(wishlistFromCustomer.get());

    }
}
