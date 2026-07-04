package com.spring_fast.main.controller;

import com.spring_fast.main.model.Payment;
import com.spring_fast.main.proxy.OpenFeignPaymentsProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class OpenFeignPaymentsController {

    private final OpenFeignPaymentsProxy openFeignPaymentsProxy;

    public OpenFeignPaymentsController(OpenFeignPaymentsProxy openFeignPaymentsProxy) {
        this.openFeignPaymentsProxy = openFeignPaymentsProxy;
    }

    @PostMapping("feign/payments")
    public Payment createPayment(
            @RequestBody Payment payment
    ) {
        String requestId = UUID.randomUUID().toString();

        return openFeignPaymentsProxy.createFeignPayment(requestId, payment);
    }
}
