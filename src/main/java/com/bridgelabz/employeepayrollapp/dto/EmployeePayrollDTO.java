package com.bridgelabz.employeepayrollapp.dto;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class EmployeePayrollDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message ="Employee name Invalid" )
    @NotEmpty(message = "Employee name cannot be null!!!")
     public   String name;
    /**
     *@NotEmpty annotation is added to name property
     * - Note that the message is thrown when the name is invalid
     *  @param name
     */
    @Min(value = 1000,message = "Minimum Salary should be more than 1000")
    public long salary;

    /**
     * Similarly @Min annotation for Salary and
     * corresponding error message
     *@param salary
     */
    public EmployeePayrollDTO(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeePayrollDTO [name=" + name + ", salary=" + salary + "]";
    }

}
