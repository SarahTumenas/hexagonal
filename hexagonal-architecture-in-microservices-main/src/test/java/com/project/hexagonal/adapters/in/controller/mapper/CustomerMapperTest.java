package com.project.hexagonal.adapters.in.controller.mapper;

import com.project.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.project.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.project.hexagonal.application.core.domain.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerMapperTest {

    @Autowired
    private CustomerMapper mapper;

    @Test
    void testToCustomer() {
        CustomerRequest request = new CustomerRequest();
        request.setName("Maria");
        request.setCpf("111.222.333-44");
        request.setZipCode("12345-678");

        Customer customer = mapper.toCustomer(request);

        assertNotNull(customer);
        assertNull(customer.getId());
        assertNull(customer.getAddress());
        assertFalse(Boolean.TRUE.equals(customer.getIsValidCpf()));
        assertEquals("Maria", customer.getName());
        assertEquals("111.222.333-44", customer.getCpf());
    }

    @Test
    void testToCustomerResponse() {
        Customer customer = new Customer();
        customer.setId("1");
        customer.setName("João");
        customer.setCpf("999.888.777-66");

        CustomerResponse response = mapper.toCustomerResponse(customer);

        assertNotNull(response);
        assertEquals("João", response.getName());
        assertEquals("999.888.777-66", response.getCpf());
    }
}
