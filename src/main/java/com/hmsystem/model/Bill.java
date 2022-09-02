package com.hmsystem.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="bills")
public class Bill {

    //columns of Bill table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "CustomerName")
    private String CustomerName;

    @Column(name = "Description")
    private String Description;

    @Column(name = "Qty")
    private String Qty;

    @Column(name = "Date")
    private String Date;

    @Column(name = "Time")
    private String Time;

    @Column(name = "Amount")
    private String amount;
}
