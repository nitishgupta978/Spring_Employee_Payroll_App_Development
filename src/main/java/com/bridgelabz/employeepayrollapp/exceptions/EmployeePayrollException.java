package com.bridgelabz.employeepayrollapp.exceptions;

/**
 * Crete a EmployeePayrollException class and extend RuntimeException
 * we call super function to get message
 */
public class EmployeePayrollException extends RuntimeException{
    public EmployeePayrollException(String message){
        super(message);
    }
}
