package com.hmsystem.controller;

import com.hmsystem.Service.Patientservice;
import com.hmsystem.model.Doctor;
import com.hmsystem.model.Patient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private Patientservice patientservice;

    public PatientController(Patientservice patientservice) {
        super();
        this.patientservice = patientservice;
    }


    //patient REST API
    @PostMapping
    public ResponseEntity<Patient> savePatient(@RequestBody Patient patient){
        return  new ResponseEntity<Patient>(patientservice.savePatient(patient), HttpStatus.CREATED);
    }

  /*  @GetMapping("/index")
    public String login(@RequestParam(name="login", required=false, defaultValue="World") String login, Login login) {
        model.addAttribute("login");
        return "greeting";
    }   */
    //get
    @GetMapping
    public List<Patient> getAllPatients(){
        return patientservice.getAllPatients();
    }

    //get patients by id
    // http://localhost:8080/api/patients/1
    @GetMapping("{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") long patientId){
        return new ResponseEntity<Patient>(patientservice.getPatientById(patientId), HttpStatus.OK);
    }

    //update patients
    // http://localhost:8080/api/patients/1
    @PutMapping("{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable("id") long id
            ,@RequestBody Patient patient){
        return new ResponseEntity<Patient>(patientservice.updatePatient(patient, id), HttpStatus.OK);

    }

    //Delete Patients
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePatient(@PathVariable("id") long id){

        // delete Patient from DB
        patientservice.deletePatient(id);

        return new ResponseEntity<String>("Patient deleted successfully!.", HttpStatus.OK);
    }
}
