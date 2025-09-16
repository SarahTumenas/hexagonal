package com.project.hexagonal.adapters.out.repository.mapper;

import com.project.hexagonal.adapters.out.repository.entity.AddressEntity;
import com.project.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.project.hexagonal.application.core.domain.Address;
import com.project.hexagonal.application.core.domain.Customer;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class CustomerEntityMapperTest {

    private final CustomerEntityMapper mapper = Mappers.getMapper(CustomerEntityMapper.class);

    @Test
    void testToCustomerEntity() {
        Address address = new Address();
        address.setStreet("Rua 1");
        address.setCity("São Paulo");
        address.setState("SP");

        Customer customer = new Customer();
        customer.setId("1");
        customer.setName("João");
        customer.setAddress(address);
        customer.setCpf("12345678900");
        customer.setIsValidCpf(true);

        CustomerEntity entity = mapper.toCustomerEntity(customer);

        assertNotNull(entity);
        assertEquals("1", entity.getId());
        assertEquals("João", entity.getName());
        assertEquals("12345678900", entity.getCpf());
        assertTrue(entity.getIsValidCpf());
        assertNotNull(entity.getAddress());
        assertEquals("Rua 1", entity.getAddress().getStreet());
    }

    @Test
    void testToCustomer() {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setStreet("Rua 2");
        addressEntity.setCity("Curitiba");
        addressEntity.setState("PR");

        CustomerEntity entity = new CustomerEntity();
        entity.setId("2");
        entity.setName("Maria");
        entity.setAddress(addressEntity);
        entity.setCpf("98765432100");
        entity.setIsValidCpf(false);

        Customer customer = mapper.toCustomer(entity);

        assertNotNull(customer);
        assertEquals("2", customer.getId());
        assertEquals("Maria", customer.getName());
        assertEquals("98765432100", customer.getCpf());
        assertFalse(customer.getIsValidCpf());
        assertNotNull(customer.getAddress());
        assertEquals("Rua 2", customer.getAddress().getStreet());
    }

    @Test
    void testNulls() {
        assertNull(mapper.toCustomerEntity(null));
        assertNull(mapper.toCustomer(null));
    }
}
