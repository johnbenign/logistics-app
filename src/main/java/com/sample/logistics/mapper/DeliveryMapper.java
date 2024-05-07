package com.sample.logistics.mapper;

import com.sample.logistics.dto.DeliveryDto;
import com.sample.logistics.entity.Delivery;

public class DeliveryMapper {
    private DeliveryMapper(){}
    public static DeliveryDto mapToDto(Delivery entity) {
        if(entity == null) return null;
        DeliveryDto dto = new DeliveryDto();
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setDeliveryCost(entity.getDeliveryCost());
        dto.setId(entity.getId());
        dto.setOrigin(DeliveryLocationMapper.mapToDto(entity.getOrigin()));
        dto.setDestination(DeliveryLocationMapper.mapToDto(entity.getDestination()));
        dto.setNumberOfPackage(entity.getNumberOfPackage());
        dto.setOptimalRoute(RouteMapper.mapToDto(entity.getOptimalRoute()));
        return dto;
    }
}
