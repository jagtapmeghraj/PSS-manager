package io.pssmanager.services;

import io.pssmanager.domain.Customer;
import io.pssmanager.exceptions.CustomerIdException;
import io.pssmanager.repositories.CustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRespository customerRespository;

    public Customer saveOrUpdateCustomer(Customer customer)
    {
        //Logic
        return customerRespository.save(customer);
    }

    public Customer saveCustomer(Customer customer)
    {
        try{
            customer.setId(customer.getId());
            return customerRespository.save(customer);
        }catch (Exception e){
            throw new CustomerIdException("customer with this id already exists.");

        }

    }

}
