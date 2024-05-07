package com.sample.logistics.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private DeliveryLocation origin;

    @ManyToOne
    private DeliveryLocation destination;

    @ManyToOne
    private Route optimalRoute;

    private Integer numberOfPackage;
    
    private BigDecimal deliveryCost;

    @CreationTimestamp
    private LocalDateTime createdAt;
}

