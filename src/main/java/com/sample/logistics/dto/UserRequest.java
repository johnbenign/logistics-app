package com.sample.logistics.dto;

import com.sample.logistics.constants.MessageConstant;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class UserRequest {
    @NotEmpty(message = MessageConstant.USER_NAME_REQUIRED)
    private String name;

    @NotEmpty(message = MessageConstant.USER_EMAIL_REQUIRED)
    @Email(message = MessageConstant.INVALID_EMAIL)
    private String email;

    @NotEmpty(message = MessageConstant.PASSWORD_REQUIRED)
    private String password;
}
