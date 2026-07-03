package com.spring_fast.main.controller;

import com.spring_fast.main.model.Payment;
import com.spring_fast.main.proxy.PaymentsProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class FeignPaymentsController {

    private final PaymentsProxy paymentsProxy;

    public FeignPaymentsController(PaymentsProxy paymentsProxy) {
        this.paymentsProxy = paymentsProxy;
    }

    @PostMapping("feign/payments")
    public Payment createPayment(
            @RequestBody Payment payment
    ) {
        String requestId = UUID.randomUUID().toString();

        return paymentsProxy.createFeignPayment(requestId, payment);
    }
}
