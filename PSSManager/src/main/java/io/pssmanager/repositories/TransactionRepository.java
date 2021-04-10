package io.pssmanager.repositories;

import io.pssmanager.domain.Customer;
import io.pssmanager.domain.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction,Long> {

    List<Transaction> findAllByCustomerIdAndDateBetween(Long id, Date fromDate, Date toDate);
}
