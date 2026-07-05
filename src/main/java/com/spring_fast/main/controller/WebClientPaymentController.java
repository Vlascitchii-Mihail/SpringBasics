package com.spring_fast.main.controller;

import com.spring_fast.main.model.Payment;
import com.spring_fast.main.proxy.WebClientPaymentProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
public class WebClientPaymentController {

    private final WebClientPaymentProxy paymentProxy;

    public WebClientPaymentController(WebClientPaymentProxy paymentProxy) {
        this.paymentProxy = paymentProxy;
    }

    @PostMapping("webclient/payments")
    public Mono<Payment> createPayment(
            @RequestBody Payment payment
    ) {
        String requestId = UUID.randomUUID().toString();
        return paymentProxy.createPayment(requestId, payment);
    }
}
