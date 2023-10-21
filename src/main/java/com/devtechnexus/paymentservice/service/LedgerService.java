package com.devtechnexus.paymentservice.service;

import com.devtechnexus.paymentservice.dto.PaymentDto;
import com.devtechnexus.paymentservice.model.PaymentRecord;
import com.devtechnexus.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class LedgerService {

    @Autowired
    private PaymentRepository paymentRepository;

    /**
     * run when payment is CREATED
     */
    public void createLedgerEntry(PaymentDto payment) {


        paymentRepository.save(new PaymentRecord(
                payment.getUid(),
                payment.getOid(),
                payment.getPrice(),
                Timestamp.valueOf(LocalDateTime.now()),
                "PENDING",
                null,
                payment.getCurrency(),
                payment.getDescription()));
    }

    /**
     * run when payment is COMPLETED or CANCELLED
     */
    public void updateLedgerEntry() {

    }

}
