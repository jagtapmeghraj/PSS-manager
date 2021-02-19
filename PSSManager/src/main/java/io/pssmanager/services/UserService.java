/*
package io.pssmanager.services;

import io.pssmanager.domain.Customer;
import io.pssmanager.domain.User;
import io.pssmanager.exceptions.UserContactException;
import io.pssmanager.repositories.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRespository userRespository;

    public User saveUser(User user)
    {
        try{
            user.setUserContact(user.getUserContact());
            return userRespository.save(user);

        }catch (Exception e){
            throw new UserContactException("User already exists.");

        }
    }

    public User updateUser(User user)
    {
        User _user = userRespository.findByUserContact(user.getUserContact());
        _user.setName(user.getName());
        _user.setAddress(user.getAddress());
        _user.setNumberofCustomers(user.getNumberofCustomers());
        _user.setTotalNumberofJars(user.getTotalNumberofJars());
        _user.setNumberofJarsinInventory(user.getNumberofJarsinInventory());
        return userRespository.save(_user);
    }

    public User findUserByContact(String userContact){

        User user = userRespository.findByUserContact(userContact);

        if(user==null){
            throw new UserContactException("There is no user registered on this number.");
        }
        return user;
    }

    public Iterable<User> findAllUsers(){
        return userRespository.findAll();
    }

    public void deleteUserByContact(String userContact){
        User user = userRespository.findByUserContact(userContact);
        if(user==null){
            throw new UserContactException("Cannot delete user. User with contact number "+ userContact +" doesn't exist.");
        }

        userRespository.delete(user);
    }
}
*/
