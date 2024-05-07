package com.sample.logistics.dto;

import com.sample.logistics.constants.MessageConstant;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class DeliveryLocationRequest {
    @NotEmpty(message = MessageConstant.DELIVERY_LOCATION_NAME_REQUIRED)
    private String name;
    @NotEmpty(message = MessageConstant.DELIVERY_ADDRESS_REQUIRED)
    private String address;
}
