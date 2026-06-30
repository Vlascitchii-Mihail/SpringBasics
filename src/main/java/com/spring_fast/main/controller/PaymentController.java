package com.spring_fast.main.controller;

import com.spring_fast.main.exceptions.NotEnoughMoneyException;
import com.spring_fast.main.model.ErrorDetails;
import com.spring_fast.main.model.PaymentDetails;
import com.spring_fast.main.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class PaymentController {

    private static Logger logger = Logger.getLogger(PaymentController.class.getName());
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<PaymentDetails> makePayment(
            @RequestBody PaymentDetails paymentDetails
    ) {
        logger.info("Payment request received: " + paymentDetails.getAmount());

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(paymentDetails);
    }
}
