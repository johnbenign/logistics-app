package com.sample.logistics.service;

import com.sample.logistics.dto.GeneralResponse;
import com.sample.logistics.dto.UserRequest;
import com.sample.logistics.exception.NotFoundException;

public interface UserService {
    GeneralResponse register(UserRequest request);
    GeneralResponse authenticate(String email, String password) throws NotFoundException;
}
