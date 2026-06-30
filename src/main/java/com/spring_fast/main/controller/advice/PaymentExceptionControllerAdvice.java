package com.spring_fast.main.controller.advice;

import com.spring_fast.main.exceptions.NotEnoughMoneyException;
import com.spring_fast.main.model.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PaymentExceptionControllerAdvice {

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> handleNotEnoughMoneyException() {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("Not enough money");

        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }
}
