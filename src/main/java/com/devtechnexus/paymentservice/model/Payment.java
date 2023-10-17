package com.devtechnexus.paymentservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Entity class for payment service
 * Fields:
 *
 *
 */
@Data
@Entity
@Table(name="payment_record")
public class Payment {

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

    @Column(name="status")
    private String status;

    /**
     * @return Datetime as UTC
     */
    public String parseTimestamp() {
        return datetime.toInstant().atZone(ZoneId.of("UTC")).toLocalDateTime() + " UTC";

    }
}
