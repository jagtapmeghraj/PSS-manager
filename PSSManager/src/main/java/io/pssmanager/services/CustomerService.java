package io.pssmanager.services;

import io.pssmanager.domain.Customer;
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
}
