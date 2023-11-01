package com.SpringBootProject.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "patients")
public class Patient {


    @Column(name = "patient_name")
    private String name;

    @Id
    @Column(name="contact_no")
    private long contactNo;

    @Column(name = "last_name")
    private String address;

    @Column(name = "pin_code")
    private String pinCode;

}
