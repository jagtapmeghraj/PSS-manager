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
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/transaction")

public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("/{customer_id}")
    public ResponseEntity<?> addNewTransaction(@Valid @RequestBody Transaction transaction, BindingResult result, @PathVariable Long customer_id, Principal principal)
    {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap!=null) return errorMap;
        Transaction _transaction = transactionService.saveTransaction(transaction, customer_id, principal.getName());
        return new ResponseEntity<Transaction>(_transaction, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTransactionById(@PathVariable Long id)
    {
        Transaction transaction = transactionService.findTransactionById(id);
        return new ResponseEntity<Transaction>(transaction,HttpStatus.OK);
    }

    @GetMapping("/halfyearrecords/{c_id}") //get transactions for last 6 months for this customer.
    public ResponseEntity<?> getTransactionByCustomerByMonth(@PathVariable Long c_id)
    {
        List<Transaction> listOfTransactions = transactionService.findTransactionsPerCustomerPerMonth(c_id);
        return new ResponseEntity<List<Transaction>>(listOfTransactions,HttpStatus.OK);
    }

}
