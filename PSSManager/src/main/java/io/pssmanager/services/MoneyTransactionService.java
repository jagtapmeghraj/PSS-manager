package io.pssmanager.services;

import io.pssmanager.domain.JarTransaction;
import io.pssmanager.domain.MoneyTransaction;
import io.pssmanager.exceptions.JarNameException;
import io.pssmanager.repositories.JarTransactionRepository;
import io.pssmanager.repositories.MoneyTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoneyTransactionService {

    @Autowired
    private MoneyTransactionRepository moneyTransactionRepository;

    public MoneyTransaction saveMoneyTransaction(MoneyTransaction moneyTransaction)
    {
        try{
            return moneyTransactionRepository.save(moneyTransaction);
        }catch (Exception e){
            throw new JarNameException("Error in saving money transaction to database");
        }
    }

    public MoneyTransaction findMoneyTransactionById(Long id){

        try{
            MoneyTransaction moneyTransaction = (moneyTransactionRepository.findById(id)).get();
            return moneyTransaction;
        }catch(Exception e){
            throw new JarNameException("There is no money transaction with id : "+id);
        }
    }
}
