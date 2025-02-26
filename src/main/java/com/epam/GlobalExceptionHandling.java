package com.epam;

import com.epam.Utility.EmployeeNotFoundException;
import com.epam.Utility.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {
   @ExceptionHandler(value = EmployeeNotFoundException.class)
  public @ResponseBody ErrorResponse handleEmployeeNotFoundException(EmployeeNotFoundException exception){
     return new ErrorResponse(exception.getMessage(),404);
  }
}
