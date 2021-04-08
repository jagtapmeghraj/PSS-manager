package io.pssmanager.web;

import io.pssmanager.domain.Transaction;
import io.pssmanager.services.TransactionService;
import io.pssmanager.services.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/jartransaction")

public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> addNewTransaction(@Valid @RequestBody Transaction transaction, BindingResult result)
    {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap!=null) return errorMap;
        Transaction _transaction = transactionService.saveTransaction(transaction);
        return new ResponseEntity<Transaction>(_transaction, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTransactionById(@PathVariable Long id)
    {
        Transaction transaction = transactionService.findTransactionById(id);
        return new ResponseEntity<Transaction>(transaction,HttpStatus.OK);
    }
}
