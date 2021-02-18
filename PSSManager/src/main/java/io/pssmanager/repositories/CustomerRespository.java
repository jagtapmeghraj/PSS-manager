package io.pssmanager.repositories;

import io.pssmanager.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRespository extends CrudRepository<Customer, Long> {

    @Override
    Iterable<Customer> findAllById(Iterable<Long> iterable);
}
