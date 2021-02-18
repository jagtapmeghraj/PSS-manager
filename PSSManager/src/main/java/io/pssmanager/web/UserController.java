package io.pssmanager.web;

import io.pssmanager.domain.User;
import io.pssmanager.services.MapValidationErrorService;
import io.pssmanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> addNewUser(@Valid @RequestBody User user , BindingResult result)
    {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap!=null) return errorMap;

        User user1 = userService.saveUser(user);
        return new ResponseEntity<User>(user1, HttpStatus.CREATED);
    }

    @GetMapping("/{userContact}")
    public ResponseEntity<?> getUserByContact(@PathVariable String userContact)
    {
        User user = userService.findUserByContact(userContact);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<User> getAllUsers(){return userService.findAllUsers();}

    @DeleteMapping("/{userContact}")
    public ResponseEntity<?> deleteUser(@PathVariable String userContact){

        userService.deleteUserByContact(userContact);
        return new ResponseEntity<String>("user with contact: '"+userContact+"' was deleted", HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<?> updateUser(@Valid @RequestBody User user, BindingResult result)
    {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap!=null) return errorMap;

        User user1 = userService.updateUser(user);
        return new ResponseEntity<User>(user1, HttpStatus.OK);
    }

}
