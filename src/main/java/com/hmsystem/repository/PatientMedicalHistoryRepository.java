package com.hmsystem.repository;

import com.hmsystem.model.Doctor;
import com.hmsystem.model.PatientMedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientMedicalHistoryRepository extends JpaRepository<PatientMedicalHistory, Long> {
}
