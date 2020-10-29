package org.arunm.event;


import org.arunm.CustomerCreated;
import org.arunm.SprintBootJpaApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CustomerEventListener {

    private static final Logger log = LoggerFactory.getLogger(CustomerEventListener.class);

    @EventListener
    public void customerCreated(CustomerCreated customerCreated) {
        log.info("Created customer with Id " + customerCreated.getCustomer().getId());
    }

}
