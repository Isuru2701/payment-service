package com.devtechnexus.paymentservice.controller;

import com.devtechnexus.paymentservice.dto.PaymentDto;
import com.devtechnexus.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(path = "/hello")
    public String makePayment(PaymentDto){

    }
}
