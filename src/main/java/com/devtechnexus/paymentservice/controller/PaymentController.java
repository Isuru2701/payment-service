package com.devtechnexus.paymentservice.controller;

import com.devtechnexus.paymentservice.dto.PaymentDto;
import com.devtechnexus.paymentservice.service.PaymentService;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    public static final String SUCCESS_URL = "pay/success";
    public static final String CANCEL_URL = "pay/cancel";

    @GetMapping(path = "/process")
    public Payment makePayment(PaymentDto payment) throws PayPalRESTException {
        return paymentService.createPayment(payment.getPrice(),
                payment.getCurrency(),
                payment.getMethod(),
                payment.getIntent(),
                payment.getDescription(),
                CANCEL_URL,
                SUCCESS_URL

        );

    }
}
