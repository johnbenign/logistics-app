package com.sample.logistics.mapper;

import com.sample.logistics.dto.UserDto;
import com.sample.logistics.dto.UserRequest;
import com.sample.logistics.entity.User;

public class UserMapper {
    private UserMapper(){}

    public static User mapToEntity(UserRequest dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        return user;
    }

    public static UserDto mapToDto(User entity) {
        UserDto dto = new UserDto();
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setId(entity.getId());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }
}
