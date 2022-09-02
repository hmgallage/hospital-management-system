package com.hmsystem.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="patientmedicalhistories")
public class PatientMedicalHistory {

    //columns of patients table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "PatientID")
    private String PatientID;

    @Column(name = "BloodPressure")
    private String BloodPressure;

    @Column(name = "BloodSugar")
    private String BloodSugar;

    @Column(name = "Weight")
    private String Weight;

    @Column(name = "Temperature")
    private String Temperature;

    @Column(name = "MedicalPres")
    private String MedicalPres;

    @Column(name = "UpdatedDate")
    private String UpdatedDate;



}
