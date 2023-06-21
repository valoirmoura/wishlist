package br.com.wishlist.services;

import br.com.wishlist.model.Customer;

import java.util.List;

public interface CustomerService {
    void customerService(Customer customer);

    List<Customer> getAllCustomers();

    Customer getByIDCustomer(String customerID);

    void removeCustomer(String customerID);
}
