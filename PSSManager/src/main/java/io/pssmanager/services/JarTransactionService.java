package io.pssmanager.services;

import io.pssmanager.domain.Customer;
import io.pssmanager.domain.Jar;
import io.pssmanager.domain.JarTransaction;
import io.pssmanager.exceptions.CustomerIdException;
import io.pssmanager.exceptions.JarNameException;
import io.pssmanager.repositories.JarTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class JarTransactionService {

    @Autowired
    private JarTransactionRepository jarTransactionRepository;

    public JarTransaction saveJarTransaction(JarTransaction jarTransaction)
    {
        try{
            return jarTransactionRepository.save(jarTransaction);
        }catch (Exception e){
            throw new JarNameException("Error in saving jar transaction to database");
        }
    }

    public JarTransaction findJarTransactionById(Long id){

        try{
            JarTransaction jarTransaction = (jarTransactionRepository.findById(id)).get();
            return jarTransaction;
        }catch(Exception e){
            throw new JarNameException("There is no jar transaction with id : "+id);
        }
    }
}
