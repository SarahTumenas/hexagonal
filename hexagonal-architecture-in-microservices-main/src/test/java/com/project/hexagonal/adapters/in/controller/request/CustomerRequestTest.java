package com.project.hexagonal.adapters.in.controller.request;

import org.junit.jupiter.api.Test;

import javax.validation.*;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRequestTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    void testGettersAndSetters() {
        CustomerRequest request = new CustomerRequest();
        request.setName("João");
        request.setCpf("12345678901");
        request.setZipCode("12345678");

        assertEquals("João", request.getName());
        assertEquals("12345678901", request.getCpf());
        assertEquals("12345678", request.getZipCode());
    }

    @Test
    void testValidation_AllFieldsBlank() {
        CustomerRequest request = new CustomerRequest();
        Set<ConstraintViolation<CustomerRequest>> violations = validator.validate(request);
        assertEquals(3, violations.size());
    }

    @Test
    void testValidation_ValidFields() {
        CustomerRequest request = new CustomerRequest();
        request.setName("Maria");
        request.setCpf("98765432100");
        request.setZipCode("87654321");

        Set<ConstraintViolation<CustomerRequest>> violations = validator.validate(request);
        assertTrue(violations.isEmpty());
    }

    @Test
    void testValidation_OneFieldBlank() {
        CustomerRequest request = new CustomerRequest();
        request.setName("Carlos");
        request.setCpf("");
        request.setZipCode("12345678");

        Set<ConstraintViolation<CustomerRequest>> violations = validator.validate(request);
        assertEquals(1, violations.size());
        assertEquals("cpf", violations.iterator().next().getPropertyPath().toString());
    }
}
