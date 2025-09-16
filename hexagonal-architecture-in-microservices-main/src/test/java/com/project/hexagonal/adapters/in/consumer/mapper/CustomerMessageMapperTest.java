package com.project.hexagonal.adapters.in.consumer.mapper;

import com.project.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.project.hexagonal.application.core.domain.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerMessageMapperTest {

    @Autowired
    private CustomerMessageMapper mapper;

    @Test
    void testToCustomerMapsFieldsCorrectly() {
        CustomerMessage message = new CustomerMessage("1", "João", "12345-678", "123.456.789-00", true);

        Customer customer = mapper.toCustomer(message);

        assertNotNull(customer);
        assertEquals("1", customer.getId());
        assertEquals("João", customer.getName());
        assertEquals("123.456.789-00", customer.getCpf());
        // O campo address deve ser ignorado (null)
        assertNull(customer.getAddress());
    }
}
