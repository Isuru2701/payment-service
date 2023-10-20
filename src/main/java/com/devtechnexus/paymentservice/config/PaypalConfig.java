package com.devtechnexus.paymentservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * PaypalConfig
 * Configuration Bean for PayPal API.
 * <br><br>
 * ALL VALUES ARE STORED IN SECRETS.PROPERTIES FILE.
 * SECRETS.PROPERTIES IS NOT COMMITTED NOR SHARED AS IT CONTAINS SENSITIVE INFORMATION.
 * <br>
 * check out the ReadME.md for more info.
 *
 */
@Configuration
public class PaypalConfig {

    @Value("${PAYPAL_CLIENT_ID}")
    private String clientId;

    @Value("${PAYPAL_CLIENT_SECRET}")
    private String clientSecret;

    @Value("${PAYPAL_MODE}")
    private String mode;
}
