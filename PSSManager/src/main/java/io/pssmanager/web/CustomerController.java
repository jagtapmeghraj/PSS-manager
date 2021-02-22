package io.pssmanager.web;

import io.pssmanager.domain.Customer;
import io.pssmanager.domain.JarTransaction;
import io.pssmanager.domain.User;
import io.pssmanager.services.CustomerService;
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
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> addNewCustomer(@Valid @RequestBody Customer customer, BindingResult result, Principal principal)
    {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap!=null) return errorMap;
        Customer _customer = customerService.saveOrUpdateCustomer(customer, principal.getName());
        return new ResponseEntity<Customer>(_customer, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id)
    {
        Customer customer = customerService.findCustomerById(id);
        return new ResponseEntity<Customer>(customer,HttpStatus.OK);
    }
    @GetMapping("/all")
    public Iterable<Customer> getAllCustomers(){return customerService.findAllCustomers();}

    @GetMapping("/allByUsername")
    public List<Customer> getAllCustomersByUsername(Principal principal )
    {
        return customerService.findAllCustomersByUsername(principal.getName());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id){

        customerService.deleteCustomerById(id);
        return new ResponseEntity<String>("Customer with id: '"+id+"' was deleted", HttpStatus.OK);
    }


}
