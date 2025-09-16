package com.project.hexagonal.adapters.in.controller.response;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddressResponseTest {

    @Test
    void testGettersAndSetters() {
        AddressResponse address = new AddressResponse();
        address.setStreet("Rua A");
        address.setCity("São Paulo");
        address.setState("SP");

        assertEquals("Rua A", address.getStreet());
        assertEquals("São Paulo", address.getCity());
        assertEquals("SP", address.getState());
    }

    @Test
    void testEqualsAndHashCode() {
        AddressResponse address1 = new AddressResponse();
        address1.setStreet("Rua A");
        address1.setCity("São Paulo");
        address1.setState("SP");

        AddressResponse address2 = new AddressResponse();
        address2.setStreet("Rua A");
        address2.setCity("São Paulo");
        address2.setState("SP");

        assertEquals(address1, address2);
        assertEquals(address1.hashCode(), address2.hashCode());
    }

    @Test
    void testToString() {
        AddressResponse address = new AddressResponse();
        address.setStreet("Rua A");
        address.setCity("São Paulo");
        address.setState("SP");

        String toString = address.toString();
        assertTrue(toString.contains("Rua A"));
        assertTrue(toString.contains("São Paulo"));
        assertTrue(toString.contains("SP"));
    }
}
