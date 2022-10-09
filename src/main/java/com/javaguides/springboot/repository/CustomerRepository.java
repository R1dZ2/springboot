package com.javaguides.springboot.repository;

import com.javaguides.springboot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> findCustomerByFirstNameContains(String firstName);

    List<Customer> findCustomerByLastNameContains(String lastName);

    Optional<Customer> findCustomerByFirstNameAndLastName(String firsName, String lastName);

    Optional<Customer> findCustomerByTelephoneNumber(int telephoneNumber);

    Optional<Customer> findCustomerByEmailAddress(String emailAddress);
}
