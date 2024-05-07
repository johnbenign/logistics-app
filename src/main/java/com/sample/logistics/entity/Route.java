package com.sample.logistics.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private DeliveryLocation origin;

    @ManyToOne
    private DeliveryLocation destination;

    private BigDecimal distanceInKilometer;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
