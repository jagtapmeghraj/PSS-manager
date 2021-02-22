package io.pssmanager.web;

import io.pssmanager.domain.Jar;
import io.pssmanager.domain.JarTransaction;
import io.pssmanager.services.JarTransactionService;
import io.pssmanager.services.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/jartransaction")

public class JarTransactionController {

    @Autowired
    private JarTransactionService jarTransactionService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> addNewJarTransaction(@Valid @RequestBody JarTransaction jarTransaction, BindingResult result)
    {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap!=null) return errorMap;
        JarTransaction _jarTransaction = jarTransactionService.saveJarTransaction(jarTransaction);
        return new ResponseEntity<JarTransaction>(_jarTransaction, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTransactionById(@PathVariable Long id)
    {
        JarTransaction jarTransaction = jarTransactionService.findJarTransactionById(id);
        return new ResponseEntity<JarTransaction>(jarTransaction,HttpStatus.OK);
    }
}
