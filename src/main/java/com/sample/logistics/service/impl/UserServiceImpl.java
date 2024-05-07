package com.sample.logistics.service.impl;

import com.sample.logistics.dto.GeneralResponse;
import com.sample.logistics.dto.UserRequest;
import com.sample.logistics.entity.User;
import com.sample.logistics.exception.BadCredentialException;
import com.sample.logistics.exception.NotFoundException;
import com.sample.logistics.mapper.UserMapper;
import com.sample.logistics.repository.UserRepository;
import com.sample.logistics.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public GeneralResponse register(UserRequest request) {
        User user = UserMapper.mapToEntity(request);
        String hashedPassword = BCrypt.hashpw(request.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);
        user = userRepository.save(user);
        return GeneralResponse.builder()
                .status(HttpStatus.CREATED.value())
                .message("User created successfully")
                .data(UserMapper.mapToDto(user))
                .build();
    }

    @Override
    public GeneralResponse authenticate(String email, String password) throws NotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("User details not found"));
        if (!BCrypt.checkpw(password, user.getPassword()))
            throw new BadCredentialException("Invalid password");
        return GeneralResponse.builder()
                .status(HttpStatus.OK.value())
                .message("Authentication successful")
                .data(UserMapper.mapToDto(user))
                .build();
    }
}