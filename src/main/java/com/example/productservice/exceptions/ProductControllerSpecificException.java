package com.example.productservice.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductControllerSpecificException extends Exception{
    ProductControllerSpecificException(String message){
        super(message);
    }
}
