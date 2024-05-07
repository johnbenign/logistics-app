package com.sample.logistics.repository;

import com.sample.logistics.entity.DeliveryLocation;
import com.sample.logistics.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {
    List<Route> findAllByOriginAndDestination(DeliveryLocation origin, DeliveryLocation destination);
}
