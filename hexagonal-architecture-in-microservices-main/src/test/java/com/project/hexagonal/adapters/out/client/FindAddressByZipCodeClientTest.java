package com.project.hexagonal.adapters.out.client;


import com.project.hexagonal.adapters.out.client.response.AddressResponse;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class FindAddressByZipCodeClientTest {

    @Test
    void testFind_ReturnsAddressResponse() {
        FindAddressByZipCodeClient client = mock(FindAddressByZipCodeClient.class);

        AddressResponse mockResponse = new AddressResponse();
        mockResponse.setStreet("Rua Teste");
        mockResponse.setCity("Cidade Teste");
        mockResponse.setState("TS");

        when(client.find("12345678")).thenReturn(mockResponse);

        AddressResponse response = client.find("12345678");

        assertNotNull(response);
        assertEquals("Rua Teste", response.getStreet());
        assertEquals("Cidade Teste", response.getCity());
        assertEquals("TS", response.getState());
    }
}
