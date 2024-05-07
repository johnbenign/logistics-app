package com.sample.logistics.dto;

import lombok.Data;

@Data
public class UpdateDeliveryLocationRequest {
    private String name;
    private String address;
}
