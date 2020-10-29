package org.arunm.service;

import java.util.List;

import org.arunm.CustomerCreated;
import org.arunm.model.Customer;
import org.arunm.repository.CustomerRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {

    private CustomerRepository customerRepository;
    private ApplicationEventPublisher applicationEventPublisher;

    public CustomerService(CustomerRepository customerRepository,ApplicationEventPublisher applicationEventPublisher) {
        this.customerRepository = customerRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
        applicationEventPublisher.publishEvent(new CustomerCreated(customer));
    }

    public List<Customer> findAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    public Customer findById(long l) {
        return customerRepository.findById(l);
    }
}
