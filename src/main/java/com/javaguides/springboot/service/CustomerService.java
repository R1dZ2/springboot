package com.javaguides.springboot.service;

import com.javaguides.springboot.dto.CustomerDto;
import com.javaguides.springboot.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> getAllCustomers();

    CustomerDto findCustomerById(Long id);

    List<CustomerDto> findCustomerByFirstName(String firstName);

    List<CustomerDto>findCustomerByLastName(String lastName);

    CustomerDto findCustomerByFirstNameAndLastName(String firsName, String lastName);

    CustomerDto findCustomerByTelephoneNumber(int telephoneNumber);

    CustomerDto findCustomerByEmailAddress(String emailAddress);

    void saveCustomer(CustomerDto customerDto);

    void updateCustomer(Long id, CustomerDto customerDto);

    void deleteCustomer(Long id);
}
