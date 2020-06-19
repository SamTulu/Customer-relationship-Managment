package edu.miu.cs.cs425.finalexam.hawkeyesupermart.customer_relationship_management.service;

import edu.miu.cs.cs425.finalexam.hawkeyesupermart.customer_relationship_management.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer>  getAllCustomers();
    List<Customer>  getAllPrimeCustomers();
    Customer saveCustomer(Customer customer);


}
