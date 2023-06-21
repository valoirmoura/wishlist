package br.com.wishlist.controller;

import br.com.wishlist.model.Customer;
import br.com.wishlist.request.ProductRequest;
import br.com.wishlist.services.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "customers")
public class CustomerController {

    private final ModelMapper modelMapper;
    private final CustomerService customerService;

    public CustomerController(ModelMapper modelMapper, CustomerService customerService) {
        this.modelMapper = modelMapper;
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ProductRequest request) {
        var usr = modelMapper.map(request, Customer.class);
        this.customerService.customerService(usr);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<Customer> getAllUsers() {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok().body(customers).getBody();
    }

    @GetMapping("/{userID}")
    public Customer getUserByID(@PathVariable String userID) {
        Customer usr = customerService.getByIDCustomer(userID);
        return ResponseEntity.ok().body(usr).getBody();
    }

    @DeleteMapping("/{userID}")
    public ResponseEntity<?> removeUser(@PathVariable String userID) {
        customerService.removeCustomer(userID);
        return ResponseEntity.noContent().build();
    }
}
