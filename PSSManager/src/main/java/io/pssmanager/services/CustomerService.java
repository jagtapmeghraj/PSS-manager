package io.pssmanager.services;

import io.pssmanager.domain.Customer;
import io.pssmanager.domain.Transaction;
import io.pssmanager.domain.User;
import io.pssmanager.exceptions.CustomerIdException;
import io.pssmanager.repositories.CustomerRespository;
import io.pssmanager.repositories.TransactionRepository;
import io.pssmanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRespository customerRespository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository jarTransactionRepository;

    public Customer saveOrUpdateCustomer(Customer customer, String username)
    {
        try{

            User user = userRepository.findByUsername(username);
            customer.setUser(user);
            return customerRespository.save(customer);
        }catch (Exception e){
            throw new CustomerIdException("Error in saving customer to database");
        }
    }

    public Customer findCustomerById(Long id)
    {
        try{
            Customer customer = (customerRespository.findById(id)).get();
            return customer;
        }catch(Exception e){
            throw new CustomerIdException("There is no customer with id : "+id);
        }
    }

    public Iterable<Customer> findAllCustomers(){
        return customerRespository.findAll();
    }

    public List<Customer> findAllCustomersByUsername(String username){

        Iterable<Customer> customers = customerRespository.findAll();
        List<Customer> res = new ArrayList<>();

        for(Customer c:customers)
        {
            User user = c.getUser();
            if(user.getUsername().equals(username)){res.add(c);}
        }
        return res;
    }

    public void deleteCustomerById(Long id){
        try {
            Customer customer = findCustomerById(id);
            customerRespository.delete(customer);
        }catch (Exception e){
            throw new CustomerIdException("Cannot delete customer with id :"+id);
        }
    }

    public Transaction addJarTransaction(Long customerId, Transaction jarTransaction)
    {
        try{
            Customer c  = findCustomerById(customerId);
            return jarTransaction;

        }catch(Exception e){
            throw new CustomerIdException("jar transaction failed");
        }
    }


}
