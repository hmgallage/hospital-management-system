package com.hmsystem.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="patients")
public class Patient {

//columns of patients table
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;


           @Column(name = "DocID")
           private String DocID;

           @Column(name = "PatientName", nullable = false)
           private String PatientName;

           @Column(name = "PatientContno")
           private String PatientContno;

           @Column(name = "PatientEmail")
           private String PatientEmail;

           @Column(name = "PatientGender")
           private String PatientGender;

           @Column(name = "PatientAdd")
           private String PatientAdd;

           @Column(name = "PatientAge")
           private String PatientAge;

           @Column(name = "PatientMedhis")
           private String PatientMedhis;





}
