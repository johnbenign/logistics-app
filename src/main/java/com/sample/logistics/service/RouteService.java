package com.sample.logistics.service;


import com.sample.logistics.dto.GeneralResponse;
import com.sample.logistics.dto.RouteDto;
import com.sample.logistics.dto.RouteRequest;

import java.util.List;

public interface RouteService {
    GeneralResponse createRoute(RouteRequest request);

    RouteDto getRoute(Long id);

    List<RouteDto> getAllRoute();
}
