package com.bridgelabz.employeepayrollapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class EmployeeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    private  String fullName;
    private String address;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

