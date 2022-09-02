package com.hmsystem.Service.Impl;

import com.hmsystem.Service.Patientservice;
import com.hmsystem.exception.ResourceNotFoundException;
import com.hmsystem.model.Patient;
import com.hmsystem.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements Patientservice {

    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }


    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(long id) {

        return patientRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Patient", "Id", id));
    }

    @Override
    public Patient updatePatient(Patient patient, long id) {

        // check whether patient with given id is exist in DB or not
        Patient existingPatient = patientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Patient", "Id", id));

        existingPatient.setDocID(patient.getDocID());
        existingPatient.setPatientName(patient.getPatientName());
        existingPatient.setPatientContno(patient.getPatientContno());
        existingPatient.setPatientEmail(patient.getPatientEmail());
        existingPatient.setPatientGender(patient.getPatientGender());
        existingPatient.setPatientAdd(patient.getPatientAdd());
        existingPatient.setPatientAge(patient.getPatientAge());
        existingPatient.setPatientMedhis(patient.getPatientMedhis());
        // save existing Patient to DB
        patientRepository.save(existingPatient);
        return existingPatient;
    }

    @Override
    public void deletePatient(long id) {

        // check whether a Patient exist in a DB or not
        patientRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Patient", "Id", id));
        patientRepository.deleteById(id);
    }
}
