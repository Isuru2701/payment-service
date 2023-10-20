package com.devtechnexus.paymentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDto {
    private double price;
    private String currency;
    private String intent;
    private String description;

}
