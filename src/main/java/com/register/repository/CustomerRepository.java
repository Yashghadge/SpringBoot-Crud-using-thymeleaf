package com.register.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.register.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
