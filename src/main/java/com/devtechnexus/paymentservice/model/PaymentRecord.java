package com.devtechnexus.paymentservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.ZoneId;

/**
 * Entity class for payment service
 *
 * <h3>Fields</h3>
 * <li>int id</li>
 * <li>int userId</li>
 * <li>float amount</li>
 * <li>Timestamp datetime</li>
 * <li>String status</li>
 *
 */
@Data
@Entity
@Table(name="payment_record")
public class PaymentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="user_id")
    private int userId;

    @Column(name="amount")
    private float amount;

    @Column(name="datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp datetime;

    /**
     * @return Datetime as UTC
     */
    public String parseTimestamp() {
        return datetime.toInstant().atZone(ZoneId.of("UTC")).toLocalDateTime() + " UTC";

    }
}
