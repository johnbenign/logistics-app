package com.sample.logistics.dto;

import com.sample.logistics.constants.MessageConstant;
import com.sample.logistics.entity.DeliveryLocation;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class RouteRequest {
    @NotNull(message = MessageConstant.ROUTE_ORIGIN_REQUIRED)
    private Long originId;
    @NotNull(message = MessageConstant.ROUTE_DESTINATION_REQUIRED)
    private Long destinationId;
    @NotNull(message = MessageConstant.DISTANCE_IN_KILOMETER_REQUIRED)
    private BigDecimal distanceInKilometer;
}
