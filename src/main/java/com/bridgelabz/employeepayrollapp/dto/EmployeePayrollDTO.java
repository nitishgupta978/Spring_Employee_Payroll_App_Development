package com.bridgelabz.employeepayrollapp.dto;


import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.List;

public @ToString class EmployeePayrollDTO {
    /**
     * @ToString USE of lombok annotation
     */

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message ="Employee name Invalid" )
   // @NotEmpty(message = "Employee name Invalid!!!")
     public   String name;
    /**
     *@NotEmpty annotation is added to name property
     * - Note that the message is thrown when the name is invalid
     *  @param name
     */
    @Min(value = 1000,message = "Minimum Salary should be more than 1000")
    public long salary;
    public  String gender;
    public String startDate;
    public String note;
    public String profilePic;
    public List<String> department;


    public EmployeePayrollDTO(String name, long salary, String gender, String startDate, String note, String profilePic, List<String> department) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.startDate = startDate;
        this.note = note;
        this.profilePic = profilePic;
        this.department = department;


    /**
     * Similarly @Min annotation for Salary and
     * corresponding error message
     *@param salary
     */

    }

}
