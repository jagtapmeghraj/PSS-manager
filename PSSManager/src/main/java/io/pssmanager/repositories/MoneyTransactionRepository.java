package io.pssmanager.repositories;

import io.pssmanager.domain.MoneyTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoneyTransactionRepository extends CrudRepository<MoneyTransaction, Long> {

}
