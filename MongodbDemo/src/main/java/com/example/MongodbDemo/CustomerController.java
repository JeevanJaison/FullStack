package com.example.MongodbDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.service.annotation.GetExchange;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import ch.qos.logback.core.model.Model;

public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private Customer customer;

    @GetMapping("/")
    public String display(Model model) {
        customerRepository.save(customer);
        return "index";
    }
}
