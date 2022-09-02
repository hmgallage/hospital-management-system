package com.hmsystem.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name="doctors")
public class Doctor {

    //columns of patients table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "DoctorName", nullable = false)
    private String DoctorName;

    @Column(name = "DoctorSpecialization")
    private String DoctorSpecialization;

    @Column(name = "Address")
    private String Address;

    @Column(name = "ContactNo")
    private String ContactNo;



}