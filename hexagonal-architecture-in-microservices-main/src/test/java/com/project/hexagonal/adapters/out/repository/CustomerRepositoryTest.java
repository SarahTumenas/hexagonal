package com.project.hexagonal.adapters.out.repository;


import com.project.hexagonal.adapters.out.repository.entity.AddressEntity;
import com.project.hexagonal.adapters.out.repository.entity.CustomerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@DataMongoTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository repository;

    @Test
    void testSaveAndFindById() {
        AddressEntity address = new AddressEntity();
        address.setStreet("Rua Teste");
        address.setCity("Cidade");
        address.setState("ST");

        CustomerEntity customer = new CustomerEntity();
        customer.setName("João");
        customer.setAddress(address);
        customer.setCpf("12345678900");
        customer.setIsValidCpf(true);

        CustomerEntity saved = repository.save(customer);

        Optional<CustomerEntity> found = repository.findById(saved.getId());
        assertTrue(found.isPresent());
        assertEquals("João", found.get().getName());
        assertEquals("12345678900", found.get().getCpf());
        assertNotNull(found.get().getAddress());
        assertEquals("Rua Teste", found.get().getAddress().getStreet());
    }

    @Test
    void testDelete() {
        CustomerEntity customer = new CustomerEntity();
        customer.setName("Maria");
        customer.setCpf("98765432100");
        customer.setIsValidCpf(false);

        CustomerEntity saved = repository.save(customer);
        repository.deleteById(saved.getId());

        Optional<CustomerEntity> found = repository.findById(saved.getId());
        assertFalse(found.isPresent());
    }
}
