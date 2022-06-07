package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.services.IEEmployeePayrollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
//@RequestMapping("/employeepayrollservice")

public class EmployeePayrollController {
    @Autowired
   private IEEmployeePayrollService employeePayrollerService;

    /**
     * we add Service and apply this  class in this class main Controller with each Method
     *
     * here call the service class like List<EmployeePayrollData> .and we stored the data in the form of List
     * and I also use ResponseDTO and Model class
     * and replace the employeePayrollData to employeePayrollDataList
     *
     * @return getEmployeePayrollData
     */
    @RequestMapping(value={"","/","/get"})
    public ResponseEntity<ResponseDTO>getEmployeePayrollData(){
        List<EmployeePayrollData> empDataList=null;
        empDataList = employeePayrollerService.getEmployeePayrollData();
    ResponseDTO responseDTO = new ResponseDTO("Get Call Successful",empDataList);
    return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);

    }
    /**
     *
     * @param employeeId we get the data of DTO and Model class with the help of GetMapping annotation
     *              and here use Service class and replace the
     *              // this hyphen to show I commit when we not use Service class where you got
     *              this meaning is same
     * @return getEmployeePayrollDataById
     */
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO>getEmployeePayrollData(@PathVariable("empId") int employeeId){
        EmployeePayrollData empData =null;
        empData= employeePayrollerService.getEmployeePayrollDataById(employeeId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call For ID Successful",empData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /**
     * findEmployeesByDepartment
     * @param department
     * @return  getEmployeePayrollDataByDepartment
     */
    @GetMapping("/department/{department}")
    public ResponseEntity<ResponseDTO>getEmployeePayrollDataByDepartment(@PathVariable("department") String department){
        List<EmployeePayrollData>employeePayrollDataList=null;
        employeePayrollDataList=employeePayrollerService.getEmployeeByDepartment(department);
        ResponseDTO responseDTO = new ResponseDTO("Get Call For Department Successfull",employeePayrollDataList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);

    }

    /**
     *@param employeePayrollDTO We CREATE the data of employeePayrollDTO in server with the help of @PotMapping Annotation
     *      *                        and by Declare path is /create and we use DTO and Model Class
     *                          we use service class also
     * @return
     */
   @PostMapping("/create")
   public ResponseEntity<ResponseDTO> createEmployeePayrollData( @Valid @RequestBody EmployeePayrollDTO employeePayrollDTO){
           log.debug(" Employee DTO",employeePayrollDTO.toString());
            EmployeePayrollData empData=null;
       empData=employeePayrollerService.createEmployeePayrollData(employeePayrollDTO);
            ResponseDTO responseDTO= new ResponseDTO("Create Employee Payroll Data Successfully:",empData);
      return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
   }

    /** add @valid annotation line no 67 for check purpose and chage String to ResponseDTO in matrix< >
     *
     * @param employeePayrollDTO We update the data of employeePayrollDTO in MySQL or Webpages with the help of @PutMapping Annotation
     *                        and by Declare path is /update and use DTO ,Model and service class
     *                           and we update the updateEmployeePayrollData with help of employeePayrollerService
     * @return ResponseDTO class
     */
   // @RequestMapping(value = "/update/{contentId:.*}", method = RequestMethod.POST)
   @PutMapping("/update/{employeeId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("employeeId")int employeeId,
                                                                 @RequestBody EmployeePayrollDTO employeePayrollDTO){
       EmployeePayrollData empData = null;
       empData=employeePayrollerService.updateEmployeePayrollData(employeeId, employeePayrollDTO);
       ResponseDTO responseDTO=new ResponseDTO("Update Employee Payroll Data Successfully",empData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
   }
    /**
     *
     * @param employeeId We delete the data of this ID of employeePayrollDTO "empId.."in MySQL or Webpages  using by @DeleteMapping @Annotation
     *              and we also use ResponseDTO class
     * @return
     */
   @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<ResponseDTO > deleteEmployeePayrollData(@PathVariable("employeeId") int employeeId){
       employeePayrollerService.deleteEmployeePayrollData(employeeId);
       ResponseDTO responseDTO = new ResponseDTO("Delete successfully","Deleted id:"+employeeId);
        return  new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
   }
/**
 * method delete by EmployeeId
 * return remaining data employeeId
 */

 }
