package com.bridgelabz.employeepayrollapp.exceptions;

import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.fasterxml.jackson.databind.util.ClassUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

/**@author Nitish kumar gupta
 * date:05-06-2022
 * EmployeePayrollExceptionHandler.java
 */
@ControllerAdvice
@Slf4j
public class EmployeePayrollExceptionHandler {
    private static final String message = "Exception while processing REST Request";
    @ExceptionHandler(HttpMessageNotReadableException .class)
    public ResponseEntity<ResponseDTO> handleHttpMessagesNotReadableException (HttpMessageNotReadableException exception){
        log.error("Invalid Data Format", exception);
       ResponseDTO responseDTO = new ResponseDTO(message,"Should have date in the format dd MMM yyyy or yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]");
       return  new ResponseEntity<>(responseDTO,HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<ObjectError>errorList = exception.getBindingResult().getAllErrors();
        List<String>errMesg = errorList.stream().map(objectError -> objectError.getDefaultMessage()).collect(Collectors.toList());
        ResponseDTO responseDTO= new ResponseDTO(message,errMesg);
        return  new ResponseEntity<>(responseDTO,HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(EmployeePayrollException.class)
    public  ResponseEntity<ResponseDTO> handleEmployeePayrollException(EmployeePayrollException exception){

        ResponseDTO responseDTO= new ResponseDTO(message,exception.getMessage());
        return new ResponseEntity<>(responseDTO,HttpStatus.BAD_REQUEST);
    }

}

