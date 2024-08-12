package com.employees.myemployees.ExceptionHandler;

import com.employees.myemployees.Models.GeneralResponse;
import com.employees.myemployees.Util.PreperResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralException {
    @ExceptionHandler
    public ResponseEntity<?> exceptionHandler(CustomExceptions e){
        GeneralResponse generalResponse = PreperResponse.preperResponse(null,"Fail","404");
        return new ResponseEntity<>(generalResponse, HttpStatus.NOT_FOUND);
    }
}
