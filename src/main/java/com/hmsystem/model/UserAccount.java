package com.hmsystem.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="useraccounts")
public class UserAccount {

    //columns of useraccounts table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "UserName")
    private String UserName;

    @Column(name = "UserType")
    private String UserType;

    @Column(name = "Password")
    private String Password;


}
