package io.pssmanager.repositories;

import io.pssmanager.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends CrudRepository<User,Long> {

    @Override
    Iterable<User> findAll();
}
