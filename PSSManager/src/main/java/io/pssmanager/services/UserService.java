package io.pssmanager.services;

import io.pssmanager.domain.Customer;
import io.pssmanager.domain.User;
import io.pssmanager.repositories.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRespository userRespository;

    public User saveOrUpdateUser(User user)
    {
        //Logic
        return userRespository.save(user);
    }
}
