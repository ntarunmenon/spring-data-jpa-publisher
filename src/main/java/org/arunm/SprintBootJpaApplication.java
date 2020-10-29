package org.arunm;

import org.arunm.model.Customer;
import org.arunm.repository.CustomerRepository;
import org.arunm.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SprintBootJpaApplication {
    private static final Logger log = LoggerFactory.getLogger(SprintBootJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SprintBootJpaApplication.class);
    }

    @Bean
    public CommandLineRunner demo(CustomerService customerService) {
        return (args) -> {
            // save a few customers
            customerService.createCustomer(new Customer("Jack", "Bauer"));
            customerService.createCustomer(new Customer("Chloe", "O'Brian"));
            customerService.createCustomer(new Customer("Kim", "Bauer"));
            customerService.createCustomer(new Customer("David", "Palmer"));
            customerService.createCustomer(new Customer("Michelle", "Dessler"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : customerService.findAll()) {
                log.info(customer.toString());
            }
            log.info("");
        };
    }


}
