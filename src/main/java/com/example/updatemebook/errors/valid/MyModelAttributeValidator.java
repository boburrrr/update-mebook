package com.example.updatemebook.errors.valid;

import com.example.updatemebook.controller.dto.SignInDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

public class MyModelAttributeValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return SignInDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SignInDto signInDto = (SignInDto) target;

        if (signInDto == null){
            errors.reject("Bu model attribute null","Bu model attribute nul bo'lishi mumkin emas?");
        }

        if (signInDto.getUsername() == null || signInDto.getUsername().isBlank()){
            errors.reject("Username null","Username null bo'lishi mumkin emas");
        }

        if (signInDto.getPassword() == null || signInDto.getPassword().isBlank()){
            errors.reject("Password null","Password null bo'lishi mumkin emas");
        }
    }
}
