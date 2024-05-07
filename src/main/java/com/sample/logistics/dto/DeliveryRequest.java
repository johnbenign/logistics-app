package com.sample.logistics.dto;

import com.sample.logistics.constants.MessageConstant;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
public class DeliveryRequest {

    @NotNull(message = MessageConstant.LOCATION_ORIGIN_REQUIRED)
    private Long originId;

    @NotNull(message = MessageConstant.LOCATION_DESTINATION_REQUIRED)
    private Long destinationId;

    @NotNull(message = MessageConstant.ENTER_NUMBER_OF_PACKAGE)
    private Integer numberOfPackage;

    @NotNull(message = MessageConstant.COST_PER_KILOMETER_REQUIRED)
    private BigDecimal costPerKilometer;
}
