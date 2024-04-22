package com.example.productservice.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidProductIdException extends Exception{
    public InvalidProductIdException(String message) {
        super(message);
    }
    //private String message;
 }
