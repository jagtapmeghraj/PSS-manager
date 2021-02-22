package io.pssmanager.web;

import io.pssmanager.domain.JarTransaction;
import io.pssmanager.domain.MoneyTransaction;
import io.pssmanager.services.MapValidationErrorService;
import io.pssmanager.services.MoneyTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/moneytransaction")
public class MoneyTransactionController {

    @Autowired
    public MoneyTransactionService moneyTransactionService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> addNewMoneyTransaction(@Valid @RequestBody MoneyTransaction moneyTransaction, BindingResult result)
    {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap!=null) return errorMap;
        MoneyTransaction _moneyTransaction = moneyTransactionService.saveMoneyTransaction(moneyTransaction);
        return new ResponseEntity<MoneyTransaction>(_moneyTransaction, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTransactionById(@PathVariable Long id)
    {
        MoneyTransaction _moneyTransaction = moneyTransactionService.findMoneyTransactionById(id);
        return new ResponseEntity<MoneyTransaction>(_moneyTransaction,HttpStatus.OK);
    }
}
