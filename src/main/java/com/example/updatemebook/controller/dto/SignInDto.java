package com.example.updatemebook.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInDto {
    @NotBlank(message = "username kiritilishi shart")
    private String username;
    @NotBlank(message = "password kiritilishi shart")
    private String password;
}
