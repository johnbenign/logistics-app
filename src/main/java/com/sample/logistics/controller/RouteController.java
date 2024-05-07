package com.sample.logistics.controller;

import com.sample.logistics.constants.ApiRoute;
import com.sample.logistics.dto.*;
import com.sample.logistics.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(ApiRoute.ROUTES)
@RequiredArgsConstructor
public class RouteController {

    private final RouteService service;

    @PostMapping(ApiRoute.CREATE)
    public ResponseEntity<GeneralResponse> create(@RequestBody @Valid RouteRequest request) {
        GeneralResponse response = service.createRoute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<RouteDto>> getAllRoutes(){
        List<RouteDto> routes = service.getAllRoute();
        return ResponseEntity.ok(routes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RouteDto> getRoute(@PathVariable Long id){
        RouteDto route = service.getRoute(id);
        return ResponseEntity.ok(route);
    }
}
