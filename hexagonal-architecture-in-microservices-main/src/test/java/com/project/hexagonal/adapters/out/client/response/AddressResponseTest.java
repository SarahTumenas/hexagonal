package com.project.hexagonal.adapters.out.client.response;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddressResponseTest {

    @Test
    void testGettersAndSetters() {
        AddressResponse address = new AddressResponse();
        address.setStreet("Rua Central");
        address.setCity("Belo Horizonte");
        address.setState("MG");

        assertEquals("Rua Central", address.getStreet());
        assertEquals("Belo Horizonte", address.getCity());
        assertEquals("MG", address.getState());
    }

    @Test
    void testEqualsAndHashCode() {
        AddressResponse address1 = new AddressResponse();
        address1.setStreet("Rua Central");
        address1.setCity("Belo Horizonte");
        address1.setState("MG");

        AddressResponse address2 = new AddressResponse();
        address2.setStreet("Rua Central");
        address2.setCity("Belo Horizonte");
        address2.setState("MG");

        assertEquals(address1, address2);
        assertEquals(address1.hashCode(), address2.hashCode());
    }

    @Test
    void testToString() {
        AddressResponse address = new AddressResponse();
        address.setStreet("Rua Central");
        address.setCity("Belo Horizonte");
        address.setState("MG");

        String str = address.toString();
        assertTrue(str.contains("Rua Central"));
        assertTrue(str.contains("Belo Horizonte"));
        assertTrue(str.contains("MG"));
    }
}
