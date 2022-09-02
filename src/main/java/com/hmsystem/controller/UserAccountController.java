package com.hmsystem.controller;

import com.hmsystem.Service.Patientservice;
import com.hmsystem.Service.UserAccountservice;
import com.hmsystem.model.Patient;
import com.hmsystem.model.UserAccount;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/useraccounts")
public class UserAccountController {

    private UserAccountservice userAccountservice;

    public UserAccountController(UserAccountservice userAccountservice) {
        super();
        this.userAccountservice = userAccountservice;
    }


    //patient REST API
    @PostMapping
    public ResponseEntity<UserAccount> saveUserAccount(@RequestBody UserAccount userAccount){
        return  new ResponseEntity<UserAccount>(userAccountservice.saveUserAccount(userAccount), HttpStatus.CREATED);
    }

    //get
    @GetMapping
    public List<UserAccount> getAllUserAccounts(){
        return userAccountservice.getAllUserAccounts();
    }

    //get patients by id
    // http://localhost:8080/api/patients/1
    @GetMapping("{id}")
    public ResponseEntity<UserAccount> getUserAccountById(@PathVariable("id") long userAccountId){
        return new ResponseEntity<UserAccount>(userAccountservice.getUserAccountById(userAccountId), HttpStatus.OK);
    }

    //update patients
    // http://localhost:8080/api/patients/1
    @PutMapping("{id}")
    public ResponseEntity<UserAccount> updateUserAccount(@PathVariable("id") long id
            ,@RequestBody UserAccount userAccount){
        return new ResponseEntity<UserAccount>(userAccountservice.updateUserAccount(userAccount, id), HttpStatus.OK);

    }

    //Delete Patients
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUserAccount(@PathVariable("id") long id){

        // delete Patient from DB
        userAccountservice.deleteUserAccount(id);

        return new ResponseEntity<String>("UserAccount deleted successfully!.", HttpStatus.OK);
    }
}
