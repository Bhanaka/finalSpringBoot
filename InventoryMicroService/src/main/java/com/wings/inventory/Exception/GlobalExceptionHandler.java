package com.wings.inventory.Exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<String> handleItemNotFoundException(ItemNotFoundException itemNotFoundException){
        log.error("Item Not Found Exception Occured ");
        ResponseEntity<String> responseEntity = new ResponseEntity<>(itemNotFoundException.getMessage(), HttpStatus.NOT_FOUND) ;
        return  responseEntity ;
    }
}
