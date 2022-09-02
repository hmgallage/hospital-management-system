package com.hmsystem.Service.Impl;

import com.hmsystem.Service.PatientMedicalHistoryservice;
import com.hmsystem.exception.ResourceNotFoundException;
import com.hmsystem.model.Patient;
import com.hmsystem.model.PatientMedicalHistory;
import com.hmsystem.repository.PatientMedicalHistoryRepository;
import com.hmsystem.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatientMedicalHistoryServiceImpl implements PatientMedicalHistoryservice {

    private PatientMedicalHistoryRepository patientMedicalHistoryRepository;

    public PatientMedicalHistoryServiceImpl(PatientMedicalHistoryRepository patientMedicalHistoryRepository) {
        this.patientMedicalHistoryRepository = patientMedicalHistoryRepository;
    }

    @Override
    public PatientMedicalHistory savePatientMedicalHistory(PatientMedicalHistory patientMedicalHistory) {
        return patientMedicalHistoryRepository.save(patientMedicalHistory);
    }


    @Override
    public List<PatientMedicalHistory> getAllPatientMedicalHistories() {
        return patientMedicalHistoryRepository.findAll();
    }

    @Override
    public PatientMedicalHistory getPatientMedicalHistoryById(long id) {

        return patientMedicalHistoryRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("PatientMedicalHistory", "Id", id));
    }

    @Override
    public PatientMedicalHistory updatePatientMedicalHistory(PatientMedicalHistory patientMedicalHistory, long id) {

        // check whether patient with given id is exist in DB or not
        PatientMedicalHistory existingPatientMedicalHistory = patientMedicalHistoryRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("PatientMedicalHistory", "Id", id));

        existingPatientMedicalHistory.setPatientID(patientMedicalHistory.getPatientID());
        existingPatientMedicalHistory.setBloodPressure(patientMedicalHistory.getBloodPressure());
        existingPatientMedicalHistory.setBloodSugar(patientMedicalHistory.getBloodSugar());
        existingPatientMedicalHistory.setWeight(patientMedicalHistory.getWeight());
        existingPatientMedicalHistory.setTemperature(patientMedicalHistory.getTemperature());
        existingPatientMedicalHistory.setMedicalPres(patientMedicalHistory.getMedicalPres());
        existingPatientMedicalHistory.setUpdatedDate(patientMedicalHistory.getUpdatedDate());
        // save existing PatientMedicalHistory to DB
        patientMedicalHistoryRepository.save(existingPatientMedicalHistory);
        return existingPatientMedicalHistory;
    }

    @Override
    public void deletePatientMedicalHistory(long id) {

        // check whether a PatientMedicalHistory exist in a DB or not
        patientMedicalHistoryRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("PatientMedicalHistory", "Id", id));
        patientMedicalHistoryRepository.deleteById(id);
    }
}
