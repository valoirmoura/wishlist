package br.com.wishlist.services.impl;

import br.com.wishlist.model.Customer;
import br.com.wishlist.repositories.CustomerRepository;
import br.com.wishlist.services.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void customerService(Customer customer) {
        customerRepository.saveCustomer(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @Override
    public Customer getByIDCustomer(String customerID) {
        return customerRepository.getByIDCustomer(customerID);
    }

    @Override
    public void removeCustomer(String customerID) {
        customerRepository.removeCustomer(customerID);
    }
}
