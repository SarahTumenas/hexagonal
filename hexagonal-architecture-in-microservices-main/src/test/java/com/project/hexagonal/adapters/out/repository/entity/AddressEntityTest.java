package com.project.hexagonal.adapters.out.repository.entity;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddressEntityTest {

    @Test
    void testGettersAndSetters() {
        AddressEntity address = new AddressEntity();
        address.setStreet("Rua Exemplo");
        address.setCity("Porto Alegre");
        address.setState("RS");

        assertEquals("Rua Exemplo", address.getStreet());
        assertEquals("Porto Alegre", address.getCity());
        assertEquals("RS", address.getState());
    }

    @Test
    void testEqualsAndHashCode() {
        AddressEntity address1 = new AddressEntity();
        address1.setStreet("Rua Exemplo");
        address1.setCity("Porto Alegre");
        address1.setState("RS");

        AddressEntity address2 = new AddressEntity();
        address2.setStreet("Rua Exemplo");
        address2.setCity("Porto Alegre");
        address2.setState("RS");

        assertEquals(address1, address2);
        assertEquals(address1.hashCode(), address2.hashCode());
    }

    @Test
    void testToString() {
        AddressEntity address = new AddressEntity();
        address.setStreet("Rua Exemplo");
        address.setCity("Porto Alegre");
        address.setState("RS");

        String str = address.toString();
        assertTrue(str.contains("Rua Exemplo"));
        assertTrue(str.contains("Porto Alegre"));
        assertTrue(str.contains("RS"));
    }
}
