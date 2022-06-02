package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
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

    /**
     *@param employeePayrollDTO We CREATE the data of employeePayrollDTO in MySQL or Webpages with the help of @PotMapping Annotation
     *      *                        and by Declare path is /create
     * @return
     */
   @PostMapping("/create")
   public ResponseEntity<String> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO){
//        employeeRepository.save(employeeDetails);
//        return "Employee Details Added SuccessFully";
      return new ResponseEntity<String>("Employee Details Added SuccessFully:"+employeePayrollDTO,HttpStatus.OK);
   }

    /**
     *
     * @param employeePayrollDTO We update the data of employeePayrollDTO in MySQL or Webpages with the help of @PutMapping Annotation
     *                        and by Declare path is /update
     * @return
     */
   @PutMapping("/update")
    public ResponseEntity<String> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO  employeePayrollDTO){
        return new ResponseEntity<String>("Update Employee Payroll Data For:"+employeePayrollDTO,HttpStatus.OK);
   }
    /**
     *
     * @param empId We delete the data of this ID of employeePayrollDTO "empId.."in MySQL or Webpages  using by @DeleteMapping @Annotation
     * @return
     */
   @DeleteMapping("/delete{empId}")
    public ResponseEntity<String > deleteEmployeePayrollData(@PathVariable("empId") int empId){
        return  new ResponseEntity<String >("Delete Call Successfull for id:"+empId,HttpStatus.OK);
   }
}
