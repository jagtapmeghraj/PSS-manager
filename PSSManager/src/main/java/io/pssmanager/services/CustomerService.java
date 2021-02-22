package io.pssmanager.services;

import io.pssmanager.domain.Customer;
import io.pssmanager.domain.JarTransaction;
import io.pssmanager.exceptions.CustomerIdException;
import io.pssmanager.repositories.CustomerRespository;
import io.pssmanager.repositories.JarTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRespository customerRespository;

    @Autowired
    private JarTransactionRepository jarTransactionRepository;

    public Customer saveorUpdateCustomer(Customer customer)
    {
        try{
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

    public void deleteCustomerById(Long id){
        try {
            Customer customer = findCustomerById(id);
            customerRespository.delete(customer);
        }catch (Exception e){
            throw new CustomerIdException("Cannot delete customer with id :"+id);
        }
    }

    public JarTransaction addJarTransaction(Long customerId, JarTransaction jarTransaction)
    {
        try{
            Customer c  = findCustomerById(customerId);
            return jarTransaction;

        }catch(Exception e){
            throw new CustomerIdException("jar transaction failed");
        }
    }


}
