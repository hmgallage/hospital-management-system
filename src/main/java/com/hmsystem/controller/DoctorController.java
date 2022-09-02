package com.hmsystem.controller;

import com.hmsystem.Service.Doctorservice;
import com.hmsystem.model.Doctor;
import com.hmsystem.model.Patient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private Doctorservice doctorservice;

    public DoctorController(Doctorservice doctorservice) {
        super();
        this.doctorservice = doctorservice;
    }

    //doctor REST API
    //create
    @PostMapping
    public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor) {
        return new ResponseEntity<Doctor>(doctorservice.saveDoctor(doctor), HttpStatus.CREATED);
    }


    //get
    @GetMapping
    public List<Doctor> getAllDoctors(){
        return doctorservice.getAllDoctors();
    }


    //update doctors
    // http://localhost:8080/api/employees/1
    @PutMapping("{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable("id") long id
            , @RequestBody Doctor doctor){
        return new ResponseEntity<Doctor>(doctorservice.updateDoctor(doctor, id), HttpStatus.OK);

    }


    //Delete doctors
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable("id") long id){

        // delete doctor from DB
        doctorservice.deleteDoctor(id);

        return new ResponseEntity<String>("Doctor Record deleted successfully!.", HttpStatus.OK);
    }
}