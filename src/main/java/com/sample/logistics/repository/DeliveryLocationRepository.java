package com.sample.logistics.repository;

import com.sample.logistics.entity.DeliveryLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryLocationRepository extends JpaRepository<DeliveryLocation, Long> {
}

