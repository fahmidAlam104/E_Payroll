package com.epam.Utility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    String errorMessage;
    int errorCode;
    public ErrorResponse(String errorMessage){
        this.errorMessage=errorMessage;
    }
}
