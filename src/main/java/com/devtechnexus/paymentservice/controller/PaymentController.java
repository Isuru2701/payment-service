package com.devtechnexus.paymentservice.controller;

import com.devtechnexus.paymentservice.dto.PaymentDto;
import com.devtechnexus.paymentservice.service.PaymentService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    private static final String HOST = "http://localhost:8084/";
    private static final String SUCCESS_URL = "payments/success";
    private static final String CANCEL_URL = "payments/cancel";

    /**
     * createPayment
     * @param payment
     * @return String redirect to PayPal
     *
     *
     */
    @PostMapping(path = "/process")
    public String createPayment(PaymentDto payment) {
        try {
            Payment paymentResponse = paymentService.createPayment(payment.getPrice(),
                    payment.getCurrency(),
                    payment.getMethod(),
                    payment.getIntent(),
                    payment.getDescription(),
                    HOST + CANCEL_URL,
                    HOST + SUCCESS_URL
            );

            for (Links link : paymentResponse.getLinks()) {
                if (link.getRel().equals("approval_url")) {
                    return "redirect:" + link.getHref();
                }
            }
        } catch (PayPalRESTException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping(SUCCESS_URL)
    public String success(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerID) {
        try{
            Payment payment = paymentService.executePayment(paymentId, payerID);

            if(payment.getState().equals("approved")){
                return "success";
            }
        }
        catch(PayPalRESTException e) {
            e.printStackTrace();
        }

        return "redirect:/";

    }

    @GetMapping(CANCEL_URL)
    public String cancel(){
        return "cancel";
    }


}
