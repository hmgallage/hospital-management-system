package com.hmsystem.Service.Impl;

import com.hmsystem.Service.Appointmentservice;
import com.hmsystem.exception.ResourceNotFoundException;
import com.hmsystem.model.Appointment;
import com.hmsystem.repository.AppointmentRepository;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class AppointmentserviceImpl implements Appointmentservice {

    private AppointmentRepository appointmentRepository;

    public AppointmentserviceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment saveAppointment(Appointment doctor) {
        return appointmentRepository.save(doctor);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getAppointmentById(long id) {
        return appointmentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Appointment", "Id", id));
    }

    @Override
    public Appointment updateAppointment(Appointment appointment, long id) {
        // check whether Doctor with given id is exist in DB or not
        Appointment existingAppointment = appointmentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Appointment", "Id", id));

        existingAppointment.setDoctorSpecialization(appointment.getDoctorSpecialization());
        existingAppointment.setContactno(appointment.getContactno());
        existingAppointment.setDate(appointment.getDate());
        existingAppointment.setTime(appointment.getTime());
        existingAppointment.setConsultancyFee(appointment.getConsultancyFee());
        // save existing Patient to DB
        appointmentRepository.save(existingAppointment);
        return existingAppointment;
    }

    @Override
    public void deleteAppointment(long id) {

        // check whether a employee exist in a DB or not
        appointmentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Appointment", "Id", id));
        appointmentRepository.deleteById(id);
    }
}
