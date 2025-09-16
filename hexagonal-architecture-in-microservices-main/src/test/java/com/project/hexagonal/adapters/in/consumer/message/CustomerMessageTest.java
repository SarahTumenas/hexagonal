package com.project.hexagonal.adapters.in.consumer.message;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerMessageTest {

    @Test
    void testAllArgsConstructorAndGetters() {
        CustomerMessage message = new CustomerMessage("1", "João", "12345-678", "123.456.789-00", true);
        assertEquals("1", message.getId());
        assertEquals("João", message.getName());
        assertEquals("12345-678", message.getZipCode());
        assertEquals("123.456.789-00", message.getCpf());
        assertTrue(message.getIsValidCpf());
    }

    @Test
    void testNoArgsConstructorAndSetters() {
        CustomerMessage message = new CustomerMessage();
        message.setId("2");
        message.setName("Maria");
        message.setZipCode("87654-321");
        message.setCpf("987.654.321-00");
        message.setIsValidCpf(false);

        assertEquals("2", message.getId());
        assertEquals("Maria", message.getName());
        assertEquals("87654-321", message.getZipCode());
        assertEquals("987.654.321-00", message.getCpf());
        assertFalse(message.getIsValidCpf());
    }

    @Test
    void testEqualsAndHashCode() {
        CustomerMessage m1 = new CustomerMessage("1", "João", "12345-678", "123.456.789-00", true);
        CustomerMessage m2 = new CustomerMessage("1", "João", "12345-678", "123.456.789-00", true);
        assertEquals(m1, m2);
        assertEquals(m1.hashCode(), m2.hashCode());
    }

    @Test
    void testToString() {
        CustomerMessage message = new CustomerMessage("1", "João", "12345-678", "123.456.789-00", true);
        String toString = message.toString();
        assertTrue(toString.contains("id=1"));
        assertTrue(toString.contains("name=João"));
        assertTrue(toString.contains("zipCode=12345-678"));
        assertTrue(toString.contains("cpf=123.456.789-00"));
        assertTrue(toString.contains("isValidCpf=true"));
    }
}
