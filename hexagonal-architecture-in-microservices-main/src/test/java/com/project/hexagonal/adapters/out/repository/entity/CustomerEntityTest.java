package com.project.hexagonal.adapters.out.repository.entity;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerEntityTest {

    @Test
    void testGettersAndSetters() {
        CustomerEntity customer = new CustomerEntity();
        AddressEntity address = new AddressEntity();
        address.setStreet("Rua 1");
        address.setCity("São Paulo");
        address.setState("SP");

        customer.setId("abc123");
        customer.setName("Maria");
        customer.setAddress(address);
        customer.setCpf("12345678900");
        customer.setIsValidCpf(true);

        assertEquals("abc123", customer.getId());
        assertEquals("Maria", customer.getName());
        assertEquals(address, customer.getAddress());
        assertEquals("12345678900", customer.getCpf());
        assertTrue(customer.getIsValidCpf());
    }

    @Test
    void testEqualsAndHashCode() {
        AddressEntity address = new AddressEntity();
        address.setStreet("Rua 1");
        address.setCity("São Paulo");
        address.setState("SP");

        CustomerEntity c1 = new CustomerEntity();
        c1.setId("abc123");
        c1.setName("Maria");
        c1.setAddress(address);
        c1.setCpf("12345678900");
        c1.setIsValidCpf(true);

        CustomerEntity c2 = new CustomerEntity();
        c2.setId("abc123");
        c2.setName("Maria");
        c2.setAddress(address);
        c2.setCpf("12345678900");
        c2.setIsValidCpf(true);

        assertEquals(c1, c2);
        assertEquals(c1.hashCode(), c2.hashCode());
    }

    @Test
    void testToString() {
        CustomerEntity customer = new CustomerEntity();
        customer.setId("abc123");
        customer.setName("Maria");
        customer.setCpf("12345678900");
        customer.setIsValidCpf(false);

        String str = customer.toString();
        assertTrue(str.contains("abc123"));
        assertTrue(str.contains("Maria"));
        assertTrue(str.contains("12345678900"));
        assertTrue(str.contains("isValidCpf=false"));
    }
}
