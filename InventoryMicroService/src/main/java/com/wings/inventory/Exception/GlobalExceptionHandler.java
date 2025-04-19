package com.wings.inventory.Exception;

import com.wings.inventory.Dto.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    // handle itemNotFoundException
    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleItemNotFoundException(ItemNotFoundException itemNotFoundException, HttpServletRequest request){
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                itemNotFoundException.getMessage(),
                LocalDateTime.now(),
                request.getRequestURI()
        ) ;
        log.error("Item Not Found Exception Occured ");
        ResponseEntity<ErrorResponse> responseEntity = new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND) ;
        return  responseEntity ;
    }
    // handle illegalArgumentException
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex , HttpServletRequest request){
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                LocalDateTime.now(),
                request.getRequestURI()
        );
        ResponseEntity<ErrorResponse> responseEntity = new ResponseEntity<ErrorResponse>(errorResponse , HttpStatus.BAD_REQUEST) ;
        return responseEntity ;
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleJsonParseError(HttpMessageNotReadableException ex , HttpServletRequest request){
        log.error("Malformed JSON request: " + ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Malformed JSON request or invalid data format",
                LocalDateTime.now(),
                request.getRequestURI()
        );
        ResponseEntity<ErrorResponse> responseEntity = new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
        return  responseEntity ;
    }
    //Generic Fallback for All Other Exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, HttpServletRequest request) {
        log.error("Unhandled Exception: ", ex);
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Something went wrong. Please try again later.",
                LocalDateTime.now(),
                request.getRequestURI()

        );
        ResponseEntity<ErrorResponse> responseEntity = new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
        return responseEntity ;
    }
}
