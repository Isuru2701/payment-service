package com.devtechnexus.paymentservice.service;

import com.devtechnexus.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LedgerService {

    @Autowired
    private PaymentRepository paymentRepository;

    /**
     * run when payment is CREATED
     */
    public void createLedgerEntry() {

    }

    /**
     * run when payment is COMPLETED or CANCELLED
     */
    public void updateLedgerEntry() {

    }
}
