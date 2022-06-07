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
       ResponseDTO responseDTO = new ResponseDTO(message,"Should have date in the format dd MMM yyyy");
       return  new ResponseEntity<>(responseDTO,HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        log.error("Invalid  profile Format ",exception);
        ResponseDTO responseDTO= new ResponseDTO(message,"Should have profile pic in string jpg ");
        return  new ResponseEntity<>(responseDTO,HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(EmployeePayrollException.class)
    public  ResponseEntity<ResponseDTO> handleEmployeePayrollException(EmployeePayrollException exception){
        log.error("Invalid Department Format!",exception);
        ResponseDTO responseDTO= new ResponseDTO(message,"Should have not empty leave Department ");
        return new ResponseEntity<>(responseDTO,HttpStatus.BAD_REQUEST);
    }

}

