package com.project.hexagonal.adapters.in.controller.response;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerResponseTest {

    @Test
    void testGettersAndSetters() {
        CustomerResponse response = new CustomerResponse();
        AddressResponse address = new AddressResponse();
        address.setStreet("Rua B");
        address.setCity("Rio de Janeiro");
        address.setState("RJ");

        response.setName("Ana");
        response.setAddress(address);
        response.setCpf("12345678900");
        response.setIsValidCpf(true);

        assertEquals("Ana", response.getName());
        assertEquals(address, response.getAddress());
        assertEquals("12345678900", response.getCpf());
        assertTrue(response.getIsValidCpf());
    }

    @Test
    void testEqualsAndHashCode() {
        AddressResponse address = new AddressResponse();
        address.setStreet("Rua B");
        address.setCity("Rio de Janeiro");
        address.setState("RJ");

        CustomerResponse resp1 = new CustomerResponse();
        resp1.setName("Ana");
        resp1.setAddress(address);
        resp1.setCpf("12345678900");
        resp1.setIsValidCpf(true);

        CustomerResponse resp2 = new CustomerResponse();
        resp2.setName("Ana");
        resp2.setAddress(address);
        resp2.setCpf("12345678900");
        resp2.setIsValidCpf(true);

        assertEquals(resp1, resp2);
        assertEquals(resp1.hashCode(), resp2.hashCode());
    }

    @Test
    void testToString() {
        CustomerResponse response = new CustomerResponse();
        response.setName("Ana");
        response.setCpf("12345678900");
        response.setIsValidCpf(false);

        String str = response.toString();
        assertTrue(str.contains("Ana"));
        assertTrue(str.contains("12345678900"));
        assertTrue(str.contains("isValidCpf=false"));
    }
}
