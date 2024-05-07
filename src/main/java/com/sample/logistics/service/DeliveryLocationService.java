package com.sample.logistics.service;

import com.sample.logistics.dto.DeliveryLocationDto;
import com.sample.logistics.dto.DeliveryLocationRequest;
import com.sample.logistics.dto.GeneralResponse;
import com.sample.logistics.dto.UpdateDeliveryLocationRequest;

import java.util.List;

public interface DeliveryLocationService {
    List<DeliveryLocationDto> getAllDeliveryLocations();
    GeneralResponse createDeliveryLocation(DeliveryLocationRequest request);
    GeneralResponse updateDeliveryLocation(Long id, UpdateDeliveryLocationRequest deliveryLocation);
    GeneralResponse deleteDeliveryLocation(Long id);
    DeliveryLocationDto getDeliveryLocationById(Long id);
}
