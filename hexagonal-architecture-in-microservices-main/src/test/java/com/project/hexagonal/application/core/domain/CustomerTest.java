package com.project.hexagonal.application.core.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void shouldCreateCustomerWithValidData() {
        // Arrange: Cria um Address de exemplo usando SEU construtor
        Address address = new Address("Rua das Flores", "São Paulo", "SP");

        // Act: Usa o construtor que tem os parâmetros corretos
        Customer customer = new Customer("123", "Sarah Tumenas", address, "123.456.789-09", true);

        // Assert: Verifica se os dados foram setados corretamente
        assertNotNull(customer, "O objeto Customer não deve ser nulo");
        assertEquals("123", customer.getId());
        assertEquals("Sarah Tumenas", customer.getName());
        assertEquals("123.456.789-09", customer.getCpf());
        assertTrue(customer.getIsValidCpf());
        assertNotNull(customer.getAddress());
        // Verifica os campos do Address conforme sua classe REAL
        assertEquals("Rua das Flores", customer.getAddress().getStreet());
        assertEquals("São Paulo", customer.getAddress().getCity());
        assertEquals("SP", customer.getAddress().getState());
    }

    @Test
    void shouldCreateCustomerWithEmptyConstructor() {
        // Act: Usa o construtor vazio
        Customer customer = new Customer();

        // Assert: Verifica se o objeto foi criado e se o isValidCpf foi inicializado como false
        assertNotNull(customer);
        assertFalse(customer.getIsValidCpf()); // Conforme seu construtor vazio
        assertNull(customer.getId());
        assertNull(customer.getName());
    }
}