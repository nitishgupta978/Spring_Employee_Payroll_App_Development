package com.bridgelabz.employeepayrollapp.exceptions;

import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.fasterxml.jackson.databind.util.ClassUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

/**@author Nitishkumar gupta
 * date:05-06-2022
 * EmployeePayrollExceptionHandler.java
 */
@ControllerAdvice
public class EmployeePayrollExceptionHandler {
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(){
        return null;
    }
    @ExceptionHandler(EmployeePayrollException.class)
    public ResponseEntity<ResponseDTO> handleEmployeePayrollException(EmployeePayrollException exception){
//        List<ObjectError> errorList=exception.getBindingResult().getAllErrors();
//        List<String> errorMessage=errorList.stream().map(objectError -> objectError.getDefaultMessage()).collect(Collectors.toList());
        ResponseDTO responseDTO= new ResponseDTO("Exception while processing REST Request",exception.getMessage());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
        /**
         * using stream api method in Exception handling
         * This is at a global level means you only have one '@ControllerAdvice' for each application And it will intercept the
         * exceptions thrown by the controllers.
         */
    }



}
