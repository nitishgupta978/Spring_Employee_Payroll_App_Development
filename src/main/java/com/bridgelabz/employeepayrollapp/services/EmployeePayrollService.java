package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEEmployeePayrollService {

    private List<EmployeePayrollData>employeePayrollDataList =new ArrayList<>();
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollDataList;
       // employeePayrollDataList.add(new EmployeePayrollData(1,new EmployeePayrollDTO("John",5000)));

    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int employeeId) {
//        EmployeePayrollData employeePayrollData=null;
//        employeePayrollData = new EmployeePayrollData(1,new EmployeePayrollDTO("Nitish",50000));

        return employeePayrollDataList.get(employeeId-1);
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData=null;
        empData=new EmployeePayrollData(employeePayrollDataList.size()+1,employeePayrollDTO);
        employeePayrollDataList.add(empData);
        return empData;
    }



//    @Override
//    public EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
//        return null;
//    }


    public EmployeePayrollData updateEmployeePayrollData(int employeeId,EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData=this.getEmployeePayrollDataById(employeeId);
       // employeePayrollData = new EmployeePayrollData(1,employeePayrollDTO);
        empData.setName(employeePayrollDTO.name);
        empData.setSalary(employeePayrollDTO.salary);
        employeePayrollDataList.set(employeeId-1,empData);

        return empData;
    }

    /**
     * delete the data of Employee payrollData with the help of empId and remove empId -1
     */
    @Override
    public void deleteEmployeePayrollData(int employeeId) {
        employeePayrollDataList.remove(employeeId-1);

    }
}
