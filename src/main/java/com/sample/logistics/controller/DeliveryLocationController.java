package com.sample.logistics.controller;

import com.sample.logistics.constants.ApiRoute;
import com.sample.logistics.dto.*;
import com.sample.logistics.service.DeliveryLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/delivery-location")
@RequiredArgsConstructor
public class DeliveryLocationController {
    private final DeliveryLocationService service;

    @PostMapping(ApiRoute.CREATE)
    public ResponseEntity<GeneralResponse> create(@RequestBody @Valid DeliveryLocationRequest request) {
        GeneralResponse response = service.createDeliveryLocation(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping(ApiRoute.EDIT + "/{id}")
    public ResponseEntity<GeneralResponse> edit(@PathVariable Long id, @RequestBody @Valid UpdateDeliveryLocationRequest request) {
        GeneralResponse response = service.updateDeliveryLocation(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<List<DeliveryLocationDto>> getAllDeliveryLocations(){
        List<DeliveryLocationDto> locations = service.getAllDeliveryLocations();
        return ResponseEntity.ok(locations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryLocationDto> getDeliveryLocation(@PathVariable Long id){
        DeliveryLocationDto location = service.getDeliveryLocationById(id);
        return ResponseEntity.ok(location);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<GeneralResponse> deleteDeliveryLocation(@PathVariable Long id){
        GeneralResponse response = service.deleteDeliveryLocation(id);
        return ResponseEntity.ok(response);
    }
}
