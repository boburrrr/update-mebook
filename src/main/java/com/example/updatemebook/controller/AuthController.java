package com.example.updatemebook.controller;

import com.example.updatemebook.controller.dto.SignInDto;
import com.example.updatemebook.controller.dto.UserDto;
import com.example.updatemebook.entity.user.Role;
import com.example.updatemebook.entity.user.UserEntity;
import com.example.updatemebook.errors.AuthenticationFailedException;
import com.example.updatemebook.errors.UserNotFoundException;
import com.example.updatemebook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/sign-in")
    public String signInPage(){
        return "/auth/sign-in";
    }

    @PostMapping("/sign-in")
    public String signIn(
            @ModelAttribute SignInDto signIn,
            Model model
    ){
        UserEntity userEntity = userService.signIn(signIn);
        if (userEntity == null){
            throw new UserNotFoundException("User not found?");
        }
        model.addAttribute("user",userEntity);
        if (userEntity.getRole().equals(Role.ADMIN)){
            return "admin";
        } else if (userEntity.getRole().equals(Role.USER)) {
            return "user";
        }else{
            return "super";
        }
    }

    @GetMapping("/sign-up")
    public String signUpPage(){
        return "/auth/sign-up";
    }

    @PostMapping("/sign-up")
    public String signUp(
            @ModelAttribute UserDto userDto
    ){
        userService.save(userDto);
        return "auth/sign-in";
    }

}
