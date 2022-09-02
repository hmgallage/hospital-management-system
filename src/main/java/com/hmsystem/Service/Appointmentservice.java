package com.hmsystem.Service;

import com.hmsystem.model.Appointment;
import com.hmsystem.model.Doctor;

import java.util.List;

public interface Appointmentservice {
    Appointment saveAppointment(Appointment appointment);
    List<Appointment> getAllAppointments();
    Appointment getAppointmentById(long id);
    Appointment updateAppointment(Appointment appointment, long id);
    void deleteAppointment(long id);
}
