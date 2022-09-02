package com.hmsystem.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="wards")
public class Ward {


    //columns of ward table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "NoOfRooms")
    private String NoOfRooms;

    @Column(name = "RoomAvailability")
    private String RoomAvailability;



}
