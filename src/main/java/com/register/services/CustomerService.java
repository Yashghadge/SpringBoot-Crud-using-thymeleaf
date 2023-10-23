package com.register.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.register.models.Customer;
import com.register.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	public List<Customer> GetAllCustomers() {
	List<Customer>	cust =customerRepository.findAll();
	return cust;
	}
	
	public void save( Customer customer) {
		customerRepository.save(customer);
	}
	
	public Customer updateCustomer(int id) {
Optional<Customer> optional = customerRepository.findById(id);
        Customer customer = null;
        if (optional.isPresent())
            customer = optional.get();
        else
            throw new RuntimeException(
                "Employee not found for id : " + id);
        return customer;
	}
	
	public void deleteCustomerById(int id) {
		customerRepository.deleteById(id);
	}
}
