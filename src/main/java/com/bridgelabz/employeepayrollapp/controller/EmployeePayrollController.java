package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import com.bridgelabz.employeepayrollapp.services.IEmployeePayrollerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/employeepayrollservice")

public class EmployeePayrollController {
    @Autowired
   private IEmployeePayrollerService employeePayrollerService;

    /**
     * we add Service and apply this  class in this class main Controller with each Method
     *
     * here call the service class like List<EmployeePayrollData> .and we stored the data in the form of List
     * and I also use ResponseDTO and Model class
     * and replace the employeePayrollData to employeePayrollDataList
     *
     * @return
     */
    @RequestMapping(value={"","/","/get"})
    public ResponseEntity<ResponseDTO>getEmployeePayrollData(){
        List<EmployeePayrollData> employeePayrollDataList=null;
        employeePayrollDataList = employeePayrollerService.getEmployeePayrollData();
//    EmployeePayrollData employeePayrollData =null;
//    employeePayrollData = new EmployeePayrollData(1,new EmployeePayrollDTO("John",300000));
    ResponseDTO responseDTO = new ResponseDTO("Get Call Successful",employeePayrollDataList);
    return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);

    }

    /**
     *
     * @param empId we get the data of DTO and Model class with the help of GetMapping annotation
     *              and here use Service class and replace the
     *              // this hyphen to show I commit when we not use Service class where you got
     *              this meaning is same
     * @return
     */
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO>getEmployeePayrollData(@PathVariable("empId") int empId){
        EmployeePayrollData employeePayrollData =null;
        employeePayrollData= employeePayrollerService.getEmployeePayrollDataById(empId);
//        employeePayrollData = new EmployeePayrollData(1,new EmployeePayrollDTO("John",3000));
        ResponseDTO responseDTO = new ResponseDTO("Get Call For ID Successful",employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /**
     *@param employeePayrollDTO We CREATE the data of employeePayrollDTO in server with the help of @PotMapping Annotation
     *      *                        and by Declare path is /create and we use DTO and Model Class
     *                          we use service class also
     * @return
     */
   @PostMapping("/create")
   public ResponseEntity<String> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO){
            EmployeePayrollData employeePayrollData=null;
            employeePayrollData=employeePayrollerService.createEmployeePayrollData(employeePayrollDTO);
//            employeePayrollData = new EmployeePayrollData(1,employeePayrollDTO);
            ResponseDTO responseDTO= new ResponseDTO("Create Employee Payroll Data Successfull:",employeePayrollData);
//        employeeRepository.save(employeeDetails);
//        return "Employee Details Added SuccessFully";
      return new ResponseEntity<String>("Employee Details Added SuccessFully:"+employeePayrollDTO,HttpStatus.OK);
   }

    /**
     *
     * @param employeePayrollDTO We update the data of employeePayrollDTO in MySQL or Webpages with the help of @PutMapping Annotation
     *                        and by Declare path is /update and use DTO ,Model and service class
     *                           and we update the updateEmployeePayrollData with help of employeePayrollerService
     * @return
     */
   @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId")int empId,
                                                                 @RequestBody EmployeePayrollDTO employeePayrollDTO){
       EmployeePayrollData employeePayrollData = null;
       employeePayrollData=employeePayrollerService.updateEmployeePayrollData(empId, employeePayrollDTO);
//       employeePayrollData=employeePayrollerService.updateEmployeePayrollData(employeePayrollDTO);
//       employeePayrollData = new EmployeePayrollData(1,employeePayrollDTO);
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
       employeePayrollerService.deleteEmployeePayrollData(empId);
       ResponseDTO responseDTO = new ResponseDTO("Delete successfully","Deleted id:"+empId);
        return  new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
   }
}
