package com.sample.logistics.mapper;

import com.sample.logistics.dto.RouteDto;
import com.sample.logistics.dto.RouteRequest;
import com.sample.logistics.entity.DeliveryLocation;
import com.sample.logistics.entity.Route;

public class RouteMapper {
    private RouteMapper(){}

    public static RouteDto mapToDto(Route entity) {
        if(entity == null) return null;
        RouteDto dto = new RouteDto();
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setId(entity.getId());
        dto.setOrigin(DeliveryLocationMapper.mapToDto(entity.getOrigin()));
        dto.setDestination(DeliveryLocationMapper.mapToDto(entity.getDestination()));
        dto.setDistanceInKilometer(entity.getDistanceInKilometer());
        return dto;
    }

    public static Route mapToEntity(RouteRequest request, DeliveryLocation origin, DeliveryLocation destination) {
        if(request == null) return null;
        Route entity = new Route();
        entity.setDestination(destination);
        entity.setOrigin(origin);
        entity.setDistanceInKilometer(request.getDistanceInKilometer());
        return entity;
    }
}
