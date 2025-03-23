package com.epam.Utility;

import lombok.Data;

@Data
public class InvalidData extends Exception{
    String message;
}
