package com.hmsystem.controller;

import com.hmsystem.Service.PatientMedicalHistoryservice;
import com.hmsystem.Service.Patientservice;
import com.hmsystem.model.Patient;
import com.hmsystem.model.PatientMedicalHistory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class PatientMedicalHistoryController {

    private PatientMedicalHistoryservice patientMedicalHistoryservice;

    public PatientMedicalHistoryController(PatientMedicalHistoryservice patientMedicalHistoryservice) {
        super();
        this.patientMedicalHistoryservice = patientMedicalHistoryservice;
    }


    //patient REST API
    @PostMapping
    public ResponseEntity<PatientMedicalHistory> savePatientMedicalHistory(@RequestBody PatientMedicalHistory patientMedicalHistory){
        return  new ResponseEntity<PatientMedicalHistory>(patientMedicalHistoryservice.savePatientMedicalHistory(patientMedicalHistory), HttpStatus.CREATED);
    }


    //get
    @GetMapping
    public List<PatientMedicalHistory> getAllPatientMedicalHistories(){
        return patientMedicalHistoryservice.getAllPatientMedicalHistories();
    }

    //get patients by id
    // http://localhost:8080/api/patients/1
    @GetMapping("{id}")
    public ResponseEntity<PatientMedicalHistory> getPatientMedicalHistoryById(@PathVariable("id") long PatientMedicalHistoryId){
        return new ResponseEntity<PatientMedicalHistory>(patientMedicalHistoryservice.getPatientMedicalHistoryById(PatientMedicalHistoryId), HttpStatus.OK);
    }

    //update patients
    // http://localhost:8080/api/patients/1
    @PutMapping("{id}")
    public ResponseEntity<PatientMedicalHistory> updatePatientMedicalHistory(@PathVariable("id") long id
            ,@RequestBody PatientMedicalHistory patientMedicalHistory){
        return new ResponseEntity<PatientMedicalHistory>(patientMedicalHistoryservice.updatePatientMedicalHistory(patientMedicalHistory, id), HttpStatus.OK);

    }

    //Delete Patients
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePatientMedicalHistory(@PathVariable("id") long id){

        // delete Patient from DB
        patientMedicalHistoryservice.deletePatientMedicalHistory(id);

        return new ResponseEntity<String>("PatientMedicalHistory deleted successfully!.", HttpStatus.OK);
    }
}
