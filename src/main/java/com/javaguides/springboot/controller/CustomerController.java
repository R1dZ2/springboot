package com.javaguides.springboot.controller;

import com.javaguides.springboot.dto.CustomerDto;
import com.javaguides.springboot.entity.Customer;
import com.javaguides.springboot.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 10000)
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping(value = "all")
    public List<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("id/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long id) {
        return new ResponseEntity<>(customerService.findCustomerById(id), HttpStatus.OK);
    }

    @GetMapping("first-name/{firstName}")
    public ResponseEntity<List<CustomerDto>> getCustomerByFirstName(@PathVariable String firstName) {
        return new ResponseEntity<>(customerService.findCustomerByFirstName(firstName), HttpStatus.OK);
    }

    @GetMapping("last-name/{lastName}")
    public ResponseEntity<List<CustomerDto>> getCustomerByLastName(@PathVariable String lastName) {
        return new ResponseEntity<>(customerService.findCustomerByLastName(lastName), HttpStatus.OK);
    }

    @GetMapping("first-last-name/{lastName}")
    public ResponseEntity<CustomerDto> getCustomerByFirstNameAndLastName(@PathVariable String firstName, String lastName) {
        return new ResponseEntity<>(customerService.findCustomerByFirstNameAndLastName(firstName,lastName), HttpStatus.OK);
    }

    @GetMapping("telephone-number/{telephoneNumber}")
    public ResponseEntity<CustomerDto> getCustomerByTelephoneNumber(@PathVariable int telephoneNumber) {
        return new ResponseEntity<>(customerService.findCustomerByTelephoneNumber(telephoneNumber), HttpStatus.OK);
    }

    @GetMapping("email/{emailAddress}")
    public ResponseEntity<CustomerDto> getCustomerByEmailAddress(@PathVariable String emailAddress) {
        return new ResponseEntity<>(customerService.findCustomerByEmailAddress(emailAddress), HttpStatus.OK);
    }

    @PostMapping(value = "save")
    public String saveCustomer(@RequestBody CustomerDto customerDto) {
        customerService.saveCustomer(customerDto);
        return "Saved...";
    }

    @PutMapping(value = "update/{id}")
    public String updateCustomer(@PathVariable Long id, @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(id, customerDto);
        return "Updated...";
    }

    @DeleteMapping(value = "delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return "Deleted product with the id " + id;
    }
}
