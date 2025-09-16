package com.project.hexagonal.adapters.out.client.mapper;

import com.project.hexagonal.adapters.out.client.response.AddressResponse;
import com.project.hexagonal.application.core.domain.Address;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class AddressResponseMapperTest {

    private final AddressResponseMapper mapper = Mappers.getMapper(AddressResponseMapper.class);

    @Test
    void testToAddress() {
        AddressResponse response = new AddressResponse();
        response.setStreet("Rua X");
        response.setCity("Curitiba");
        response.setState("PR");

        Address address = mapper.toAddress(response);

        assertNotNull(address);
        assertEquals("Rua X", address.getStreet());
        assertEquals("Curitiba", address.getCity());
        assertEquals("PR", address.getState());
    }

    @Test
    void testToAddress_Null() {
        Address address = mapper.toAddress(null);
        assertNull(address);
    }
}
