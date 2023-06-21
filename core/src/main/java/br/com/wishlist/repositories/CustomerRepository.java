package br.com.wishlist.repositories;

import br.com.wishlist.model.Customer;

import java.util.List;

public interface CustomerRepository {

    void saveCustomer(Customer customer);

    List<Customer> getAllCustomers();

    Customer getByIDCustomer(String userID);

    void removeCustomer(String userID);
}
