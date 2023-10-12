package com.example.updatemebook.controller;

import com.example.updatemebook.controller.dto.UpdateUserDto;
import com.example.updatemebook.controller.dto.UserDto;
import com.example.updatemebook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/update/{userId}")
    public String updatePage(
            @PathVariable() UUID userId,
            Model model
            ){
        model.addAttribute("user",userService.getById(userId));
        return "/user/update";
    }
    @PostMapping("/update/{userId}")
    public String update(
            @PathVariable UUID userId,
            @ModelAttribute UpdateUserDto updateUserDto,
            Model model
            ){
        userService.update(userId,updateUserDto);
        model.addAttribute("user",userService.getById(userId));
        return "user";
    }

}
