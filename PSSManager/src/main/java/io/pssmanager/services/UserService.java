package io.pssmanager.services;

import io.pssmanager.domain.User;
import io.pssmanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user)
    {
        return user;
    }

    public User updateUser(User user)
    {
       return user;
    }

    public User findUserByContact(String userContact){

        return new User();
    }

    public Iterable<User> findAllUsers(){
        return userRepository.findAll();
    }

    public void deleteUserByContact(String userContact){
        User user = userRepository.findByUserContact(userContact);

        userRepository.delete(user);
    }
}
