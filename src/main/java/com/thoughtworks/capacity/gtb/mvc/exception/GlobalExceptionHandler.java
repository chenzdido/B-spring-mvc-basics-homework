package com.thoughtworks.capacity.gtb.mvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResult> handle(UserNotFoundException ex){
        ErrorResult errorResult = new ErrorResult(404,ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResult);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResult> handle(MethodArgumentNotValidException ex){
        String message = ex.getBindingResult().getFieldError().getDefaultMessage();
        ErrorResult errorResult = new ErrorResult(400,message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResult> handle(ConstraintViolationException ex){
        String message = "";
        for (ConstraintViolation<?> constraint : ex.getConstraintViolations()) {
            message = constraint.getMessage();
            break;
        }
        ErrorResult errorResult = new ErrorResult(400,message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

    @ExceptionHandler(UserNameDuplicate.class)
    public ResponseEntity<ErrorResult> handle(UserNameDuplicate ex){
        ErrorResult errorResult = new ErrorResult(400,ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

    @ExceptionHandler(UserPasswordWrong.class)
    public ResponseEntity<ErrorResult> handle(UserPasswordWrong ex){
        ErrorResult errorResult = new ErrorResult(400,ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }
}
