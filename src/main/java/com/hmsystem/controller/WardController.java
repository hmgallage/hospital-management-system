package com.hmsystem.controller;

import com.hmsystem.Service.Patientservice;
import com.hmsystem.Service.Wardservice;
import com.hmsystem.model.Patient;
import com.hmsystem.model.Ward;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wards")
public class WardController {

    private Wardservice wardservice;

    public WardController(Wardservice wardservice) {
        super();
        this.wardservice = wardservice;
    }


    //patient REST API
    @PostMapping
    public ResponseEntity<Ward> saveWard(@RequestBody Ward ward){
        return  new ResponseEntity<Ward>(wardservice.saveWard(ward), HttpStatus.CREATED);
    }

    //get
    @GetMapping
    public List<Ward> getAllWards(){
        return wardservice.getAllWards();
    }

    //get patients by id
    // http://localhost:8080/api/Wards/1
    @GetMapping("{id}")
    public ResponseEntity<Ward> getWardById(@PathVariable("id") long wardId){
        return new ResponseEntity<Ward>(wardservice.getWardById(wardId), HttpStatus.OK);
    }

    //update patients
    // http://localhost:8080/api/Wards/1
    @PutMapping("{id}")
    public ResponseEntity<Ward> updateWard(@PathVariable("id") long id
            , @RequestBody Ward ward){
        return new ResponseEntity<Ward>(wardservice.updateWard(ward, id), HttpStatus.OK);

    }

    //Delete Patients
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteWard(@PathVariable("id") long id){

        // delete Patient from DB
        wardservice.deleteWard(id);

        return new ResponseEntity<String>("Ward deleted successfully!.", HttpStatus.OK);
    }
}
