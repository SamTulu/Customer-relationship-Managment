package edu.miu.cs.cs425.finalexam.hawkeyesupermart.customer_relationship_management.service.impl;

import edu.miu.cs.cs425.finalexam.hawkeyesupermart.customer_relationship_management.model.Customer;
import edu.miu.cs.cs425.finalexam.hawkeyesupermart.customer_relationship_management.repository.CustomerRepository;
import edu.miu.cs.cs425.finalexam.hawkeyesupermart.customer_relationship_management.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class customerServiceImpl  implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll(Sort.by(Sort.Direction.ASC , "fullName"));
    }

    @Override
    public List<Customer> getAllPrimeCustomers() {
        List<Customer> allCustomers = customerRepository.findAll();

        List<Customer> primeCustomers = new ArrayList<>();

        for(Customer c: allCustomers){
            long age = ChronoUnit.YEARS.between(c.getDateOfBirth(), LocalDate.now());
            if(age>=40) primeCustomers.add(c);
        }
        return primeCustomers;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
