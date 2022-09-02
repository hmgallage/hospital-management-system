package com.hmsystem.Service;

import com.hmsystem.model.Doctor;
import com.hmsystem.model.Patient;

import java.util.List;

public interface Doctorservice {
    Doctor saveDoctor(Doctor doctor);
    List<Doctor> getAllDoctors();
    Doctor getDoctorById(long id);
    Doctor updateDoctor(Doctor doctor, long id);
    void deleteDoctor(long id);

}
