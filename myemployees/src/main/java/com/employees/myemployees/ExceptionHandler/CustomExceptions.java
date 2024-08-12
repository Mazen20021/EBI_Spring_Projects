package com.employees.myemployees.ExceptionHandler;

import com.employees.myemployees.Models.DTO.EmployeesDTO;

import java.util.Optional;

public class CustomExceptions extends RuntimeException{

    private String code;
    private String message;
    private EmployeesDTO employeesDTO;
    public CustomExceptions(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public EmployeesDTO getEmployeesDTO() {
        return employeesDTO;
    }

    public void setEmployeesDTO(EmployeesDTO employeesDTO) {
        this.employeesDTO = employeesDTO;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
