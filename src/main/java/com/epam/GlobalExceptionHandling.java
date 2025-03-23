package com.epam;

import com.epam.Utility.EntityNotFoundException;
import com.epam.Utility.ErrorResponse;
import com.epam.Utility.InvalidDataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandling {
   @ExceptionHandler(value = EntityNotFoundException.class)
  public @ResponseBody ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(EntityNotFoundException exception, WebRequest request){
       String path= request.getDescription(false);
       Date date=new Date();
     return new ResponseEntity<>(new ErrorResponse(exception.getMessage(),path
                                           ,date.toString(),HttpStatus.NOT_FOUND.toString()),HttpStatus.NOT_FOUND);
  }
    @ExceptionHandler(value = InvalidDataException.class)
    public @ResponseBody ResponseEntity<ErrorResponse> handleInvalidDataException(InvalidDataException exception, WebRequest request){
        String path= request.getDescription(false);
        Date date=new Date();
        return new ResponseEntity<>(new ErrorResponse(exception.getMessage(),path
                ,date.toString(),HttpStatus.BAD_REQUEST.toString()),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public @ResponseBody ResponseEntity<ErrorResponse> handleUrlNotFoundException(HttpRequestMethodNotSupportedException exception
                                         , WebRequest request){
        String path= request.getDescription(false);
        Date date=new Date();
        return new ResponseEntity<>(new ErrorResponse(exception.getMessage(),path
                ,date.toString(),HttpStatus.METHOD_NOT_ALLOWED.toString()),HttpStatus.METHOD_NOT_ALLOWED);
    }
}
