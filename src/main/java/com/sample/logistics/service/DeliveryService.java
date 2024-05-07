package com.sample.logistics.service;

import com.sample.logistics.dto.DeliveryRequest;
import com.sample.logistics.dto.GeneralResponse;

public interface DeliveryService {
    GeneralResponse deliver(DeliveryRequest request);
}
