package org.arunm;

import org.arunm.model.Customer;

public class CustomerCreated {

    private Customer customer;

    public CustomerCreated(Customer customer) {
        this.customer = customer;
    }


    public Customer getCustomer() {
        return customer;
    }
}
