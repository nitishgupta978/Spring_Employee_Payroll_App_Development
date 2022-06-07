package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.exceptions.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeePayrollService implements IEEmployeePayrollService {
    @Autowired
    private EmployeeRepository employeeRepository;

    private List<EmployeePayrollData>employeePayrollDataList ;

    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeeRepository.findAll();
       // employeePayrollDataList.add(new EmployeePayrollData(1,new EmployeePayrollDTO("John",5000)));

    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(() ->new EmployeePayrollException("Employee payroll employeeId"+employeeId+"does not exists!!"));
//        return  employeePayrollDataList.stream().filter(employeePayrollData ->
//                        employeePayrollData.getEmployeeId()==employeeId)
//                .findFirst().orElseThrow(() ->new EmployeePayrollException("Employee not found"));
/**
 * Using stream api method to get Employee with help of getEmployeePayrollDataById method
 * here pass Exception condition if employeeId have then showed otherwise get Employee not found exception
 */

    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData=null;
        empData=new EmployeePayrollData(employeePayrollDTO);
      //  employeePayrollDataList.add(empData);
        log.debug("Employee Data"+empData.toString());
        return employeeRepository.save(empData) ;
    }

    public EmployeePayrollData updateEmployeePayrollData(int employeeId,EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData=this.getEmployeePayrollDataById(employeeId);
        empData.updateEmployeePayrollData(employeePayrollDTO);
        return employeeRepository.save(empData);
    }


    @Override
    public void deleteEmployeePayrollData(int employeeId) {
        EmployeePayrollData employeePayrollData=this.getEmployeePayrollDataById(employeeId);
        employeePayrollDataList.remove(employeeId-1);

    }
}
