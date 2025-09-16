package com.project.hexagonal.adapters.in.controller;

import com.project.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.project.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.project.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.project.hexagonal.application.core.domain.Customer;
import com.project.hexagonal.application.ports.in.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // Habilita o Mockito
class CustomerControllerTest {

    @Mock
    private InsertCustomerInputPort insertCustomerInputPort;

    @Mock
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Mock
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Mock
    private DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;

    @Mock
    private CustomerMapper customerMapper;

    @InjectMocks // Injeta os mocks no controller
    private CustomerController controller;

    @Test
    void testInsert() {
        // Arrange
        CustomerRequest request = new CustomerRequest();
        request.setName("Sarah");
        request.setCpf("123.456.789-09");
        request.setZipCode("12345-678");

        Customer customer = new Customer();
        when(customerMapper.toCustomer(request)).thenReturn(customer);

        // Act
        ResponseEntity<Void> response = controller.insert(request);

        // Assert
        verify(insertCustomerInputPort).insert(customer, "12345-678");
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void testFindById() {
        // Arrange
        String id = "1";
        Customer customer = new Customer();
        CustomerResponse customerResponse = new CustomerResponse();

        when(findCustomerByIdInputPort.find(id)).thenReturn(customer);
        when(customerMapper.toCustomerResponse(customer)).thenReturn(customerResponse);

        // Act
        ResponseEntity<CustomerResponse> response = controller.findById(id);

        // Assert
        verify(findCustomerByIdInputPort).find(id);
        verify(customerMapper).toCustomerResponse(customer);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(customerResponse, response.getBody());
    }

    @Test
    void testUpdate() {
        // Arrange
        String id = "1";
        CustomerRequest request = new CustomerRequest();
        request.setZipCode("99999-999");
        Customer customer = new Customer();

        when(customerMapper.toCustomer(request)).thenReturn(customer);

        // Act
        ResponseEntity<Void> response = controller.update(id, request);

        // Assert
        assertEquals(id, customer.getId());
        verify(updateCustomerInputPort).update(customer, "99999-999");
        assertEquals(204, response.getStatusCodeValue());
    }

    @Test
    void testDelete() {
        // Arrange
        String id = "1";

        // Act
        ResponseEntity<Void> response = controller.delete(id);

        // Assert
        verify(deleteCustomerByIdInputPort).delete(id);
        assertEquals(204, response.getStatusCodeValue());
    }
}