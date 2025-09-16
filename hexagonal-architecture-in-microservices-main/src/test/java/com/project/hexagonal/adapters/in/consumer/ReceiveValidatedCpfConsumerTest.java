package com.project.hexagonal.adapters.in.consumer;


import com.project.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.project.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.project.hexagonal.application.core.domain.Customer;
import com.project.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;

@SpringBootTest
class ReceiveValidatedCpfConsumerTest {

    @Autowired
    private ReceiveValidatedCpfConsumer consumer;

    @MockBean
    private UpdateCustomerInputPort updateCustomerInputPort;

    @MockBean
    private CustomerMessageMapper customerMessageMapper;

    @Test
    void testReceiveShouldCallUpdateCustomer() {
        CustomerMessage message = new CustomerMessage("1", "João", "12345-678", "123.456.789-00", true);
        Customer customer = mock(Customer.class);

        when(customerMessageMapper.toCustomer(message)).thenReturn(customer);

        consumer.receive(message);

        verify(customerMessageMapper, times(1)).toCustomer(message);
        verify(updateCustomerInputPort, times(1)).update(customer, "12345-678");
    }
}
