package com.spring_fast.main.controller;

import com.spring_fast.main.model.Payment;
import com.spring_fast.main.proxy.RestTemplateProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTemplateController {

    private final RestTemplateProxy paymentProxy;

    public RestTemplateController(RestTemplateProxy paymentProxy) {
        this.paymentProxy = paymentProxy;
    }

    @PostMapping("rest_template/payments")
    public Payment createPayment(
            @RequestBody Payment payment
    ) {
        return paymentProxy.createPayment(payment);
    }
}
