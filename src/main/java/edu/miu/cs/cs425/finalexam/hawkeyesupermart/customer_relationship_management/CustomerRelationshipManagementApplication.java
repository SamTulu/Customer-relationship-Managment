package edu.miu.cs.cs425.finalexam.hawkeyesupermart.customer_relationship_management;

import edu.miu.cs.cs425.finalexam.hawkeyesupermart.customer_relationship_management.model.Customer;
import edu.miu.cs.cs425.finalexam.hawkeyesupermart.customer_relationship_management.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class CustomerRelationshipManagementApplication implements CommandLineRunner {

    @Autowired
    CustomerService customerService;

    public static void main(String[] args) {
        SpringApplication.run(CustomerRelationshipManagementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        customerService.saveCustomer(new Customer(1L, "C-100000001", "John W. Smith", "", LocalDate.of(1980,6,29)));
        customerService.saveCustomer(new Customer(2L, "C-100000002", "Anna-Marrie Rodriguez", "641-451-0001", LocalDate.of(1989,12,7)));
        customerService.saveCustomer(new Customer(3L, "PC-100000003", "Jane C. Ortiz", "240-109-1123", LocalDate.of(1980,6,17)));
        customerService.saveCustomer(new Customer(4L, "C-100000004", "Susan Hemmingway-Booth", "", LocalDate.of(1994,3,27)));
        customerService.saveCustomer(new Customer(5L, "PC-100000005", "Ben James Franklin", "", LocalDate.of(1951,11,18)));



    }
}
