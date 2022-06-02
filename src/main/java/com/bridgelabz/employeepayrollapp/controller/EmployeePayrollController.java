package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
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
    public ResponseEntity<ResponseDTO>getEmployeePayrollData(){
    EmployeePayrollData employeePayrollData =null;
    employeePayrollData = new EmployeePayrollData(1,new EmployeePayrollDTO("John",300000));
    ResponseDTO responseDTO = new ResponseDTO("Get Call Successful",employeePayrollData);
    return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);

    }
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO>getEmployeePayrollData(@PathVariable("empId") int empId){
        EmployeePayrollData employeePayrollData =null;
        employeePayrollData = new EmployeePayrollData(1,new EmployeePayrollDTO("John",3000));
        ResponseDTO responseDTO = new ResponseDTO("Get Call For ID Successful",employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
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
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO){
       EmployeePayrollData employeePayrollData = null;
       employeePayrollData = new EmployeePayrollData(1,employeePayrollDTO);
       ResponseDTO responseDTO=new ResponseDTO("Update Employee Payroll Data Successfully",employeePayrollData);

        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
   }
    /**
     *
     * @param empId We delete the data of this ID of employeePayrollDTO "empId.."in MySQL or Webpages  using by @DeleteMapping @Annotation
     *              and we also use ResponseDTO class
     * @return
     */
   @DeleteMapping("/delete{empId}")
    public ResponseEntity<ResponseDTO > deleteEmployeePayrollData(@PathVariable("empId") int empId){
       ResponseDTO responseDTO = new ResponseDTO("Delete successfully","Deleted id:"+empId);
        return  new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
   }
}
