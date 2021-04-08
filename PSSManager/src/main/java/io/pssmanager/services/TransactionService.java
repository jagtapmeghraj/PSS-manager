package io.pssmanager.services;

import io.pssmanager.domain.Transaction;
import io.pssmanager.exceptions.TransactionException;
import io.pssmanager.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction saveTransaction(Transaction jarTransaction)
    {
        try{
            return transactionRepository.save(jarTransaction);
        }catch (Exception e){
            throw new TransactionException("Error in saving jar transaction to database");
        }
    }

    public Transaction findTransactionById(Long id){

        try{
            Transaction jarTransaction = (transactionRepository.findById(id)).get();
            return jarTransaction;
        }catch(Exception e){
            throw new TransactionException("There is no jar transaction with id : "+id);
        }
    }
}
