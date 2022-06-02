package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollerService{

    private List<EmployeePayrollData>employeePayrollDataList =new ArrayList<>();
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollDataList;
       // employeePayrollDataList.add(new EmployeePayrollData(1,new EmployeePayrollDTO("John",5000)));

    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
//        EmployeePayrollData employeePayrollData=null;
//        employeePayrollData = new EmployeePayrollData(1,new EmployeePayrollDTO("Nitish",50000));

        return employeePayrollDataList.get(empId-1);
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData=null;
        employeePayrollData=new EmployeePayrollData(employeePayrollDataList.size()+1,employeePayrollDTO);
        return employeePayrollData;
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        return null;
    }

//    @Override
//    public EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
//        return null;
//    }


    public EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData=this.getEmployeePayrollDataById(empId);
       // employeePayrollData = new EmployeePayrollData(1,employeePayrollDTO);
        employeePayrollData.setName(employeePayrollDTO.name);
        employeePayrollData.setSalary(employeePayrollDTO.salary);
        employeePayrollDataList.set(empId-1,employeePayrollData);

        return employeePayrollData;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        employeePayrollDataList.remove(empId-1);

    }
}
