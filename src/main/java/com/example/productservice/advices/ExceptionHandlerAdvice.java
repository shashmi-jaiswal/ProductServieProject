package com.example.productservice.advices;

import com.example.productservice.exceptions.ArithmeticHandleExceptionDto;
import com.example.productservice.exceptions.ArrayOUIHandlerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ArithmeticHandleExceptionDto> ArithmeticHandleException() {
        ArithmeticHandleExceptionDto arithmeticHandleExceptionDto = new ArithmeticHandleExceptionDto();
        arithmeticHandleExceptionDto.setMessage("Something went wrong");
        arithmeticHandleExceptionDto.setDetail("Arithmetic exception");

        return new ResponseEntity<>(arithmeticHandleExceptionDto, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ArrayOUIHandlerDto> ArrayOUIHandlerException(){
        ArrayOUIHandlerDto arrayOUIHandlerDto = new ArrayOUIHandlerDto();
        arrayOUIHandlerDto.setMessage("Sometihng went wrong");
        arrayOUIHandlerDto.setDetail("Array Out of Index");
        return new ResponseEntity<>(arrayOUIHandlerDto, HttpStatus.BAD_REQUEST);
    }
    //Write exception for InvalidId
//    public void invalidIdHandlerException(){
//
//    }
}



