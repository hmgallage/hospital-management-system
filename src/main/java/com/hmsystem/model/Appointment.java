package com.hmsystem.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="appointments")
public class Appointment {

    //columns of Appointment table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "DocID")
    private String DocID;

    @Column(name = "DoctorSpecialization")
    private String DoctorSpecialization;

    @Column(name = "Contactno")
    private String Contactno;

    @Column(name = "Date")
    private String Date;

    @Column(name = "Time")
    private String Time;

    @Column(name = "ConsultancyFee")
    private String ConsultancyFee;

}
