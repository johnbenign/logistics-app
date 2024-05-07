package com.sample.logistics.mapper;

import com.sample.logistics.constants.MessageConstant;
import com.sample.logistics.dto.DeliveryLocationDto;
import com.sample.logistics.dto.DeliveryLocationRequest;
import com.sample.logistics.entity.DeliveryLocation;

import javax.validation.constraints.NotNull;

public class DeliveryLocationMapper {

    public static DeliveryLocationDto mapToDto(DeliveryLocation entity) {
        if(entity == null) return null;
        DeliveryLocationDto dto = new DeliveryLocationDto();
        dto.setAddress(entity.getAddress());
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

public static DeliveryLocation mapToEntity(@NotNull(message = MessageConstant.DELIVERY_REQUEST_REQUIRED) DeliveryLocationRequest dto) {
        DeliveryLocation entity = new DeliveryLocation();
        entity.setAddress(dto.getAddress());
        entity.setName(dto.getName());
        return entity;
    }
}
