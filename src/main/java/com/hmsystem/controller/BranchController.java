package com.hmsystem.controller;

import com.hmsystem.Service.Branchservice;
import com.hmsystem.Service.Patientservice;
import com.hmsystem.model.Branch;
import com.hmsystem.model.Patient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Branches")
public class BranchController {

    private Branchservice branchservice;

    public BranchController(Branchservice branchservice) {
        super();
        this.branchservice = branchservice;
    }


    //patient REST API
    @PostMapping
    public ResponseEntity<Branch> saveBranch(@RequestBody Branch branch){
        return  new ResponseEntity<Branch>(branchservice.saveBranch(branch), HttpStatus.CREATED);
    }

    //get
    @GetMapping
    public List<Branch> getAllBranches(){
        return branchservice.getAllBranches();
    }

    //get patients by id
    // http://localhost:8080/api/patients/1
    @GetMapping("{id}")
    public ResponseEntity<Branch> getBranchById(@PathVariable("id") long branchId){
        return new ResponseEntity<Branch>(branchservice.getBranchById(branchId), HttpStatus.OK);
    }

    //update patients
    // http://localhost:8080/api/patients/1
    @PutMapping("{id}")
    public ResponseEntity<Branch> updateBranch(@PathVariable("id") long id
            , @RequestBody Branch branch){
        return new ResponseEntity<Branch>(branchservice.updateBranch(branch, id), HttpStatus.OK);

    }

    //Delete Patients
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBranch(@PathVariable("id") long id){

        // delete Patient from DB
        branchservice.deleteBranch(id);

        return new ResponseEntity<String>("Branch deleted successfully!.", HttpStatus.OK);
    }
}
