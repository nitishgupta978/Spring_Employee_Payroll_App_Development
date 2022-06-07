package com.bridgelabz.employeepayrollapp.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    @Pattern(regexp = "male|female",message = "Gender should be male or female")
    public  String gender;

    //@JsonFormat(pattern ="dd MMM yyyy")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
//    private LocalDateTime updatedTime;
    @NotNull(message = "Start date should be not Empty")
    @PastOrPresent(message = "startDate should be past or today date")
    public LocalDate startDate;

    @NotBlank(message = "Note cannot be Empty")
    public String note;
    @NotBlank(message = "department should not be Empty")
    public String profilePic;
    @NotNull(message = "Department should not be empty")
    public List<String> department;

    /**
     * Similarly @Min annotation for Salary and
     * corresponding error message
     *@param salary More than 1000
     * Adding validations in every EmployeePayrollDTO
     */


    public EmployeePayrollDTO(String name, long salary, String gender, LocalDate startDate, String note, String profilePic, List<String> department) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.startDate = startDate;
        this.note = note;
        this.profilePic = profilePic;
        this.department = department;



    }

}
