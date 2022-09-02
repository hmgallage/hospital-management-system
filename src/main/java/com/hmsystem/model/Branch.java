package com.hmsystem.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="branches")
public class Branch {


    //columns of Branch table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "BranchName")
    private String BranchName;

    @Column(name = "Address")
    private String Address;

    @Column(name = "ContactNo")
    private String ContactNo;


}

