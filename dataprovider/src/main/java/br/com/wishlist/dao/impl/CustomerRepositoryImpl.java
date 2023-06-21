package br.com.wishlist.dao.impl;

import br.com.wishlist.dao.CustomerDAO;
import br.com.wishlist.document.CustomerDocument;
import br.com.wishlist.model.Customer;
import br.com.wishlist.repositories.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final ModelMapper modelMapper;
    private final CustomerDAO customerDAO;

    public CustomerRepositoryImpl(ModelMapper modelMapper, CustomerDAO customerDAO) {
        this.modelMapper = modelMapper;
        this.customerDAO = customerDAO;
    }

    @Override
    public void saveCustomer(Customer customer) {
        var usr = modelMapper.map(customer, CustomerDocument.class);
        customerDAO.save(usr);
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<CustomerDocument> users = customerDAO.findAll();
        return users.stream()
                .map(usr -> modelMapper.map(usr, Customer.class))
                .toList();
    }

    @Override
    public Customer getByIDCustomer(String userID) {
        Optional<CustomerDocument> usr = customerDAO.findById(userID);
        return modelMapper.map(usr, Customer.class);
    }

    @Override
    public void removeCustomer(String userID) {
        Optional<CustomerDocument> usr = customerDAO.findById(userID);
        customerDAO.delete(usr.get());

    }
}
