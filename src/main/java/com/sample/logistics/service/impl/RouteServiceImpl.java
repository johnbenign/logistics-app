package com.sample.logistics.service.impl;

import com.sample.logistics.dto.GeneralResponse;
import com.sample.logistics.dto.RouteDto;
import com.sample.logistics.dto.RouteRequest;
import com.sample.logistics.entity.DeliveryLocation;
import com.sample.logistics.entity.Route;
import com.sample.logistics.exception.NotFoundException;
import com.sample.logistics.mapper.RouteMapper;
import com.sample.logistics.repository.DeliveryLocationRepository;
import com.sample.logistics.repository.RouteRepository;
import com.sample.logistics.service.RouteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j(topic = "RouteService")
public class RouteServiceImpl implements RouteService {
    private final RouteRepository repository;
    private final DeliveryLocationRepository deliveryLocationRepository;

    @Override
    public GeneralResponse createRoute(RouteRequest request){
        DeliveryLocation origin = deliveryLocationRepository.findById(request.getOriginId()).orElseThrow(() -> new NotFoundException("Origin location not found"));
        DeliveryLocation destination = deliveryLocationRepository.findById(request.getDestinationId()).orElseThrow(() -> new NotFoundException("Destination location not found"));
        Route route = RouteMapper.mapToEntity(request, origin, destination);
        route = repository.save(route);
        return GeneralResponse.builder()
                .status(HttpStatus.CREATED.value())
                .message("Route created successfully")
                .data(RouteMapper.mapToDto(route))
                .build();
    }

    @Override
    public RouteDto getRoute(Long id){
        Route route = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Route not found with given id"));
        return RouteMapper.mapToDto(route);
    }

    @Override
    public List<RouteDto> getAllRoute(){
        return repository.findAll()
                .stream()
                .map(RouteMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
