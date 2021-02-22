package io.pssmanager.repositories;

import io.pssmanager.domain.JarTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JarTransactionRepository extends CrudRepository<JarTransaction,Long> {


}
