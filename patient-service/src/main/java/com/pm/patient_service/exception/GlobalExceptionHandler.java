package com.pm.patient_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>>handleValidException(MethodArgumentNotValidException ex){
        HashMap<String,String>errors=new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(eror->errors.put(eror.getField(),eror.getDefaultMessage()));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<Map<String,String>>patientNotFoundException(PatientNotFoundException ex){
        HashMap<String,String>error=new HashMap<>();
        error.put("message",ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
    @ExceptionHandler(EmailExistException.class)
    public ResponseEntity<Map<String,String>>emailExistException(EmailExistException ex){
        HashMap<String,String>error=new HashMap<>();
        error.put("message", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
}
