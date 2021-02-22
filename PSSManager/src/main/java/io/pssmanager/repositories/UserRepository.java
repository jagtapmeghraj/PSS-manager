package io.pssmanager.repositories;

import io.pssmanager.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    User findByUserContact(String userContact);

    @Override
    Iterable<User> findAll();
}
