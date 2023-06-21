package br.com.wishlist.model;

public class Customer {
    private String customerID;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public Customer() {
    }

    public Customer(String customerID, String firstName, String lastName, String email, String password) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
