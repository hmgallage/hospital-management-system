package com.hmsystem.Service;

import com.hmsystem.model.Patient;

import java.util.List;

public interface Patientservice {
    Patient savePatient(Patient patient);
    List<Patient> getAllPatients();
    Patient getPatientById(long id);
    Patient updatePatient(Patient patient, long id);
    void deletePatient(long id);

}
