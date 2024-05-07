package com.sample.logistics.service.impl;

import com.sample.logistics.dto.DeliveryLocationDto;
import com.sample.logistics.dto.DeliveryLocationRequest;
import com.sample.logistics.dto.GeneralResponse;
import com.sample.logistics.dto.UpdateDeliveryLocationRequest;
import com.sample.logistics.entity.DeliveryLocation;
import com.sample.logistics.exception.NotFoundException;
import com.sample.logistics.mapper.DeliveryLocationMapper;
import com.sample.logistics.repository.DeliveryLocationRepository;
import com.sample.logistics.service.DeliveryLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeliveryLocationServiceImpl implements DeliveryLocationService {
    private final DeliveryLocationRepository deliveryLocationRepository;

    @Override
    public List<DeliveryLocationDto> getAllDeliveryLocations() {
        return deliveryLocationRepository.findAll()
                .stream()
                .map(DeliveryLocationMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public GeneralResponse createDeliveryLocation(DeliveryLocationRequest request) {
        DeliveryLocation deliveryLocation = DeliveryLocationMapper.mapToEntity(request);
        deliveryLocation = deliveryLocationRepository.save(deliveryLocation);
        return GeneralResponse.builder()
                .message("Delivery location added successfully")
                .status(HttpStatus.CREATED.value())
                .data(DeliveryLocationMapper.mapToDto(deliveryLocation))
                .build();
    }

    @Override
    public GeneralResponse updateDeliveryLocation(Long id, UpdateDeliveryLocationRequest request) {
        DeliveryLocation deliveryLocation = deliveryLocationRepository.findById(id).orElseThrow(() -> new NotFoundException("Location not found with given id"));
        if(StringUtils.hasText(request.getName()))
            deliveryLocation.setName(request.getName());
        if(StringUtils.hasText(request.getAddress()))
            deliveryLocation.setAddress(request.getAddress());
        deliveryLocation = deliveryLocationRepository.save(deliveryLocation);
        deliveryLocation = deliveryLocationRepository.save(deliveryLocation);
        return GeneralResponse.builder()
                .message("Delivery location updated successfully")
                .status(HttpStatus.OK.value())
                .data(DeliveryLocationMapper.mapToDto(deliveryLocation))
                .build();

    }

    @Override
    public GeneralResponse deleteDeliveryLocation(Long id) {
        if(!deliveryLocationRepository.existsById(id))
            throw new NotFoundException("Location not found with given id");
        deliveryLocationRepository.deleteById(id);
        return GeneralResponse.builder()
                .message("Deleted successfully")
                .status(HttpStatus.OK.value())
                .build();
    }

    @Override
    public DeliveryLocationDto getDeliveryLocationById(Long id){
        DeliveryLocation existingDeliveryLocation = deliveryLocationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Location not found with given id"));
        return DeliveryLocationMapper.mapToDto(existingDeliveryLocation);
    }
}