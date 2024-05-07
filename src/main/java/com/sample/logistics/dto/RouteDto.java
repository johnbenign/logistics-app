package com.sample.logistics.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sample.logistics.entity.DeliveryLocation;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class RouteDto {
    private Long id;

    private DeliveryLocationDto origin;

    private DeliveryLocationDto destination;

    private BigDecimal distanceInKilometer;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime createdAt;
}
