package com.hmsystem.Service.Impl;

import com.hmsystem.Service.Doctorservice;
import com.hmsystem.exception.ResourceNotFoundException;
import com.hmsystem.model.Doctor;
import com.hmsystem.model.Patient;
import com.hmsystem.repository.DoctorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DoctorServiceImpl implements Doctorservice {

    private DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctorById(long id) {
        return doctorRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Doctor", "Id", id));
    }

    @Override
    public Doctor updateDoctor(Doctor doctor, long id) {
        // check whether Doctor with given id is exist in DB or not
        Doctor existingDoctor = doctorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Doctor", "Id", id));

        existingDoctor.setDoctorName(doctor.getDoctorName());
        existingDoctor.setDoctorSpecialization(doctor.getDoctorSpecialization());
        existingDoctor.setAddress(doctor.getAddress());
        existingDoctor.setContactNo(doctor.getContactNo());
        // save existing Patient to DB
        doctorRepository.save(existingDoctor);
        return existingDoctor;
    }

    @Override
    public void deleteDoctor(long id) {

        // check whether a employee exist in a DB or not
        doctorRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Doctor", "Id", id));
        doctorRepository.deleteById(id);
    }


}
