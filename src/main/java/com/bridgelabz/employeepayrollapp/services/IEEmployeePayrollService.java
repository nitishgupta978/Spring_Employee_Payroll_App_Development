package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

import java.util.List;


public interface IEEmployeePayrollService {
    List<EmployeePayrollData> getEmployeePayrollData();
    EmployeePayrollData getEmployeePayrollDataById(int employeeId);
    List<EmployeePayrollData>getEmployeeByDepartment(String department);

    /**
     *Add to
     * IEmployeePayrollService Interface a new method getEmployeesByDepartment
     * @param employeePayrollDTO
     * @return  getEmployeeByDepartment
     */
    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);
   // EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);

    void deleteEmployeePayrollData(int employeeId);

    EmployeePayrollData updateEmployeePayrollData(int employeeId, EmployeePayrollDTO employeePayrollDTO);
}
