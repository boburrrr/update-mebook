package com.example.updatemebook.controller.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String name;
    @NotBlank(message = "username kiritilishi shart")
    private String username;
    @NotBlank(message = "email kiritilishi shart")
    private String email;
    @NotBlank(message = "password kiritilishi shart")
    private String password;
}
