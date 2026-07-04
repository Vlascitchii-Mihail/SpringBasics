package com.spring_fast.main.proxy;

import com.spring_fast.main.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "payments", url = "${name.service.url}")
public interface OpenFeignPaymentsProxy {

    @PostMapping("payment")
    Payment createFeignPayment(
            @RequestHeader String requestId,
            @RequestBody Payment payment
    );
}
