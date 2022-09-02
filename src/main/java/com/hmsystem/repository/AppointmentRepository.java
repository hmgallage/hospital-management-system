package com.hmsystem.repository;

import com.hmsystem.model.Appointment;
import com.hmsystem.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
