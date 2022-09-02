package com.hmsystem.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="stores")
public class Store {

    //columns of Store table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "MedicineName")
    private String MedicineName;

    @Column(name = "Category")
    private String Category;

    @Column(name = "Mdate")
    private String Mdate;

    @Column(name = "EDate")
    private String EDate;

    @Column(name = "AvailableQTY")
    private String AvailableQTY;

}
