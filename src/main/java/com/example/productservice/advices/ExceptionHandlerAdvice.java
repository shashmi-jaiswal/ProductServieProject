package com.example.productservice.advices;

import com.example.productservice.dtos.ArithmeticHandleExceptionDto;
import com.example.productservice.dtos.ArrayOUIHandlerDto;
import com.example.productservice.dtos.InvalidProductIdExceptionDto;
import com.example.productservice.exceptions.InvalidProductIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
//Whatever data is passing through the Controller passes through Controller Advice
// This wil act as a sensor board before seding anything to the client
//One of the jobs it can do is to return somethinf useful to the client before sending the exceotion
//THe controller can do itself but it will have a lot of jobs instead of just calling the service only/
//Thus violating the SRP.
//This will get triggered anytime the controller gets an exception of the following classes as defined
// with the @ExceptionHandler annotation

//ArithmeticException - ex: any number divided by zero
public class ExceptionHandlerAdvice {
    //ArithmeticException - ex: any number divided by zero
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ArithmeticHandleExceptionDto> ArithmeticHandleException() {
        //Here write the code of what you want to send to client when such a exception is thrown
        ArithmeticHandleExceptionDto arithmeticHandleExceptionDto = new ArithmeticHandleExceptionDto();
        arithmeticHandleExceptionDto.setMessage("Something went wrong due to arithmetics maybe");
        arithmeticHandleExceptionDto.setDetail("Arithmetic exception");

        return new ResponseEntity<>(arithmeticHandleExceptionDto, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ArrayOUIHandlerDto> ArrayOUIHandlerException(){
        ArrayOUIHandlerDto arrayOUIHandlerDto = new ArrayOUIHandlerDto();
        arrayOUIHandlerDto.setMessage("Something went wrong");
        arrayOUIHandlerDto.setDetail("Array Out of Index");
        return new ResponseEntity<>(arrayOUIHandlerDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidProductIdException.class)
    public  ResponseEntity<InvalidProductIdExceptionDto> InvalidProductIdExceptionHandler(){

        InvalidProductIdExceptionDto invalidProductIdExceptionDto= new InvalidProductIdExceptionDto();
        invalidProductIdExceptionDto.setMessage("Invalid product Id, please try with another id");
        return new ResponseEntity<>(invalidProductIdExceptionDto, HttpStatus.BAD_REQUEST);

    }
}



