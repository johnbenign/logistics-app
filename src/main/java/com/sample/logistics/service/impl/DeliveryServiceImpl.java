package com.sample.logistics.service.impl;

import com.sample.logistics.dto.DeliveryRequest;
import com.sample.logistics.dto.GeneralResponse;
import com.sample.logistics.entity.Delivery;
import com.sample.logistics.entity.DeliveryLocation;
import com.sample.logistics.entity.Route;
import com.sample.logistics.exception.ConstraintException;
import com.sample.logistics.exception.NotFoundException;
import com.sample.logistics.mapper.DeliveryMapper;
import com.sample.logistics.repository.DeliveryLocationRepository;
import com.sample.logistics.repository.DeliveryRepository;
import com.sample.logistics.repository.RouteRepository;
import com.sample.logistics.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j(topic = "DeliveryService")
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository repository;
    private final RouteRepository routeRepository;
    private final DeliveryLocationRepository deliveryLocationRepository;

    @Override
    public GeneralResponse deliver(DeliveryRequest request){
        DeliveryLocation origin = deliveryLocationRepository.findById(request.getOriginId()).orElseThrow(() -> new NotFoundException("Origin not found with given id"));
        DeliveryLocation destination = deliveryLocationRepository.findById(request.getDestinationId())
                        .orElseThrow(() -> new NotFoundException("Destination was not found with the given id"));
        List<DeliveryLocation> deliveryLocations = deliveryLocationRepository.findAll();
        if(deliveryLocations.size() < 3)
            throw new ConstraintException("Minimum of 3 locations must exist before deliveries can start");
        List<Route> routes = routeRepository.findAllByOriginAndDestination(origin, destination);
        BigDecimal leastCost = null;
        Double shortestPath = null;
        Route shortestRoute = new Route();
        for(Route route : routes){
            if(shortestPath == null)
                shortestPath = route.getDistanceInKilometer().doubleValue();
            if(shortestPath > route.getDistanceInKilometer().doubleValue()) {
                shortestPath = route.getDistanceInKilometer().doubleValue();
                shortestRoute = route;
            }
            if(leastCost == null)
                leastCost = request.getCostPerKilometer().multiply(route.getDistanceInKilometer()).multiply(new BigDecimal(request.getNumberOfPackage()));
            BigDecimal totalCost = request.getCostPerKilometer().multiply(route.getDistanceInKilometer()).multiply(new BigDecimal(request.getNumberOfPackage()));
            log.info("total cost: {}", totalCost);
            log.info("current least cost: {}", leastCost);
            if(leastCost.doubleValue() > totalCost.doubleValue())
                leastCost = totalCost;
        }
        return recordDelivery(shortestRoute, leastCost, request.getNumberOfPackage());
    }

    private GeneralResponse recordDelivery(Route shortestRoute, BigDecimal leastCost, Integer numberOfPackage) {
        Delivery delivery = new Delivery();
        delivery.setDeliveryCost(leastCost);
        delivery.setDestination(shortestRoute.getDestination());
        delivery.setOrigin(shortestRoute.getOrigin());
        delivery.setOptimalRoute(shortestRoute);
        delivery.setNumberOfPackage(numberOfPackage);
        delivery = repository.save(delivery);
        return GeneralResponse.builder()
                .message("Delivered successfully")
                .status(HttpStatus.CREATED.value())
                .data(DeliveryMapper.mapToDto(delivery))
                .build();
    }
}
