package com.sample.logistics.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sample.logistics.entity.DeliveryLocation;
import com.sample.logistics.entity.Route;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class DeliveryDto {
    private Long id;

    private DeliveryLocationDto origin;

    private DeliveryLocationDto destination;

    private RouteDto optimalRoute;

    private Integer numberOfPackage;

    private BigDecimal deliveryCost;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime createdAt;
}
