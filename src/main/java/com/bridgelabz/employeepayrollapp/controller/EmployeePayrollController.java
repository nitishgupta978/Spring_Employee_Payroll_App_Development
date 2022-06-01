package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.model.EmployeeDetails;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/employeepayrollservice")

public class EmployeePayrollController {
    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping(value={"","/","/get"})
    public ResponseEntity<String>getEmployeePayrollData(){
return new ResponseEntity<String>("Get Call Success for id:",HttpStatus.OK);
    }
    @GetMapping("/get/{empId}")
    public ResponseEntity<String>getEmployeePayrollData(@PathVariable("empId") int empId){
        return new ResponseEntity<String>("Get Call Success for id:"+empId,HttpStatus.OK);
    }
   @PostMapping("/create")
   public String addEmployeePayrollData(@RequestBody EmployeeDetails employeeDetails){
        employeeRepository.save(employeeDetails);
        return "Employee Details Added SuccessFully";
   }

   @PutMapping("/update")
    public ResponseEntity<String> updateEmployeePayrollData(@RequestBody EmployeeDetails employeeDetails){
        return new ResponseEntity<String>("Update Employee Payroll Data For:"+employeeDetails,HttpStatus.OK);

   }

    /**
     *
     * @param empId
     * @return
     */
   @DeleteMapping("/delete{empId}")
    public ResponseEntity<String > deleteEmployeePayrollData(@PathVariable("empId") int empId){
        return  new ResponseEntity<String >("Delete Call Successfull for id:"+empId,HttpStatus.OK);
   }
}
