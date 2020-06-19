package edu.miu.cs.cs425.finalexam.hawkeyesupermart.customer_relationship_management.repository;

import edu.miu.cs.cs425.finalexam.hawkeyesupermart.customer_relationship_management.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
