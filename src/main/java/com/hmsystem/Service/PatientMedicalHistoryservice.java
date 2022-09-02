package com.hmsystem.Service;

import com.hmsystem.model.Doctor;
import com.hmsystem.model.PatientMedicalHistory;

import java.util.List;

public interface PatientMedicalHistoryservice {
    PatientMedicalHistory savePatientMedicalHistory(PatientMedicalHistory patientMedicalHistory);
    List<PatientMedicalHistory> getAllPatientMedicalHistories();
    PatientMedicalHistory getPatientMedicalHistoryById(long id);
    PatientMedicalHistory updatePatientMedicalHistory(PatientMedicalHistory patientMedicalHistory, long id);
    void deletePatientMedicalHistory(long id);
}
