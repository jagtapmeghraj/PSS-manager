package io.pssmanager.services;

import io.pssmanager.domain.Customer;
import io.pssmanager.domain.Transaction;
import io.pssmanager.domain.User;
import io.pssmanager.exceptions.TransactionException;
import io.pssmanager.repositories.CustomerRespository;
import io.pssmanager.repositories.TransactionRepository;
import io.pssmanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerRespository customerRespository;

    public Transaction saveTransaction(Transaction transaction, Long customer_id,  String username)
    {
        try{
            Customer customer  = customerRespository.findById(customer_id).get();
            transaction.setCustomer(customer);
            User user = userRepository.findByUsername(username);
            transaction.setUser(user);
            return transactionRepository.save(transaction);
        }catch (Exception e){
            throw new TransactionException("Error in saving transaction to database : "+ e);
        }
    }

    public Transaction findTransactionById(Long id){

        try{
            Transaction jarTransaction = (transactionRepository.findById(id)).get();
            return jarTransaction;
        }catch(Exception e){
            throw new TransactionException("There is no transaction with id : "+id);
        }
    }

    //get transactions fro last 6 month for given customer
    public List<Transaction> findTransactionsPerCustomerPerMonth(Long c_id){

        try{
            List<Transaction> resList = new ArrayList<>();
            Date toDate = new Date();
            Date fromDate = Date.from(ZonedDateTime.now().minusMonths(6).toInstant());
            resList = transactionRepository.findAllByCustomerIdAndDateBetween(c_id, fromDate, toDate);
            return resList;


        }catch(Exception e){
            throw new TransactionException("Error while fetching transactions");
        }
    }
}
