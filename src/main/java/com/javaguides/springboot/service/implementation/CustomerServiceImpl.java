package com.javaguides.springboot.service.implementation;

import com.javaguides.springboot.dto.CustomerDto;
import com.javaguides.springboot.entity.Customer;
import com.javaguides.springboot.repository.CustomerRepository;
import com.javaguides.springboot.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerDto> customerDtoList = customerList.stream().map(customer -> {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setId(customer.getId());
            customerDto.setAddress(customer.getAddress());
            customerDto.setEmailAddress(customer.getEmailAddress());
            customerDto.setFirstName(customer.getFirstName());
            customerDto.setLastName(customer.getLastName());
            customerDto.setTelephoneNumber(customer.getTelephoneNumber());
            return customerDto;
        }).collect(Collectors.toList());
        return customerDtoList;
    }

    @Override
    public CustomerDto findCustomerById(Long id) {
        var customer = customerRepository.findById(id).orElse(null);
        if (Objects.nonNull(customer)) {
            var customerDto = new CustomerDto();
            customerDto.setId(customer.getId());
            customerDto.setAddress(customer.getAddress());
            customerDto.setEmailAddress(customer.getEmailAddress());
            customerDto.setFirstName(customer.getFirstName());
            customerDto.setLastName(customer.getLastName());
            customerDto.setTelephoneNumber(customer.getTelephoneNumber());
            return customerDto;
        } else {
            return null;
        }
    }

    @Override
    public List<CustomerDto> findCustomerByFirstName(String firstName) {
        var customerList = customerRepository.findCustomerByFirstNameContains(firstName);
        var customerDtoList = customerList.stream().map(customer -> {
            var customerDto = new CustomerDto();
            customerDto.setId(customer.getId());
            customerDto.setAddress(customer.getAddress());
            customerDto.setEmailAddress(customer.getEmailAddress());
            customerDto.setFirstName(customer.getFirstName());
            customerDto.setLastName(customer.getLastName());
            customerDto.setTelephoneNumber(customer.getTelephoneNumber());
            return customerDto;
        }).collect(Collectors.toList());
        return customerDtoList;
    }

    @Override
    public List<CustomerDto> findCustomerByLastName(String lastName) {
        List<Customer> customerList = customerRepository.findCustomerByLastNameContains(lastName);
        List<CustomerDto> customerDtoList = customerList.stream().map(customer -> {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setId(customer.getId());
            customerDto.setAddress(customer.getAddress());
            customerDto.setEmailAddress(customer.getEmailAddress());
            customerDto.setFirstName(customer.getFirstName());
            customerDto.setLastName(customer.getLastName());
            customerDto.setTelephoneNumber(customer.getTelephoneNumber());
            return customerDto;
        }).collect(Collectors.toList());
        return customerDtoList;
    }

    @Override
    public CustomerDto findCustomerByFirstNameAndLastName(String firsName, String lastName) {
        Customer customer = customerRepository.findCustomerByFirstNameAndLastName(firsName, lastName).orElse(null);
        if (Objects.nonNull(customer)) {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setId(customer.getId());
            customerDto.setAddress(customer.getAddress());
            customerDto.setEmailAddress(customer.getEmailAddress());
            customerDto.setFirstName(customer.getFirstName());
            customerDto.setLastName(customer.getLastName());
            customerDto.setTelephoneNumber(customer.getTelephoneNumber());
            return customerDto;
        } else {
            return null;
        }
    }

    @Override
    public CustomerDto findCustomerByTelephoneNumber(int telephoneNumber) {
        Customer customer = customerRepository.findCustomerByTelephoneNumber(telephoneNumber).orElse(null);
        if (Objects.nonNull(customer)) {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setId(customer.getId());
            customerDto.setAddress(customer.getAddress());
            customerDto.setEmailAddress(customer.getEmailAddress());
            customerDto.setFirstName(customer.getFirstName());
            customerDto.setLastName(customer.getLastName());
            customerDto.setTelephoneNumber(customer.getTelephoneNumber());
            return customerDto;
        } else {
            return null;
        }
    }

    @Override
    public CustomerDto findCustomerByEmailAddress(String emailAddress) {
        Customer customer = customerRepository.findCustomerByEmailAddress(emailAddress).orElse(null);
        if (Objects.nonNull(customer)) {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setId(customer.getId());
            customerDto.setAddress(customer.getAddress());
            customerDto.setEmailAddress(customer.getEmailAddress());
            customerDto.setFirstName(customer.getFirstName());
            customerDto.setLastName(customer.getLastName());
            customerDto.setTelephoneNumber(customer.getTelephoneNumber());
            return customerDto;
        } else {
            return null;
        }
    }

    @Override
    public void saveCustomer(CustomerDto customerDto) {
        if (Objects.nonNull(customerDto)) {
            Customer customer = new Customer();
            customer.setAddress(customerDto.getAddress());
            customer.setLastName(customerDto.getLastName());
            customer.setId(customerDto.getId());
            customer.setFirstName(customerDto.getFirstName());
            customer.setEmailAddress(customerDto.getEmailAddress());
            customer.setTelephoneNumber(customerDto.getTelephoneNumber());
            customerRepository.save(customer);
        }

    }

    @Override
    public void updateCustomer(Long id, CustomerDto customerDto) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (Objects.nonNull(customer)){
            customer.setAddress(customerDto.getAddress());
            customer.setLastName(customerDto.getLastName());
            customer.setId(customerDto.getId());
            customer.setFirstName(customerDto.getFirstName());
            customer.setEmailAddress(customerDto.getEmailAddress());
            customer.setTelephoneNumber(customerDto.getTelephoneNumber());
            customerRepository.save(customer);
        }
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer customer=customerRepository.findById(id).orElse(null);
        if (Objects.nonNull(customer)){
            customerRepository.delete(customer);
        }
    }
}
