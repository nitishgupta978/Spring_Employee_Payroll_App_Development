package com.bridgelabz.employeepayrollapp.dto;


public class EmployeePayrollDTO {
    private long id;
    private String name;
    private String salary;

    public EmployeePayrollDTO(long id, String name, String salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;

    }

    @Override
    public String toString() {
        return "EmployeePayrollDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
