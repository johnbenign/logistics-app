package com.sample.logistics.controller;

import com.sample.logistics.constants.ApiRoute;
import com.sample.logistics.dto.DeliveryLocationRequest;
import com.sample.logistics.dto.DeliveryRequest;
import com.sample.logistics.dto.GeneralResponse;
import com.sample.logistics.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/delivery")
@RequiredArgsConstructor
public class DeliveryController {
    private final DeliveryService service;

    @PostMapping(ApiRoute.DELIVER_PACKAGE)
    public ResponseEntity<GeneralResponse> create(@RequestBody @Valid DeliveryRequest request) {
        GeneralResponse response = service.deliver(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
