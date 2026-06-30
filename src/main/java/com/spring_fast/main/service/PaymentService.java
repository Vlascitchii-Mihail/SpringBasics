package com.spring_fast.main.service;

import com.spring_fast.main.exceptions.NotEnoughMoneyException;
import com.spring_fast.main.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentDetails processPyment() {
        throw new NotEnoughMoneyException();
    }
}
