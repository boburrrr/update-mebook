package com.example.updatemebook.service;

import com.example.updatemebook.controller.dto.SignInDto;
import com.example.updatemebook.controller.dto.UpdateUserDto;
import com.example.updatemebook.controller.dto.UserDto;
import com.example.updatemebook.entity.user.Role;
import com.example.updatemebook.entity.user.UserEntity;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserEntity save(UserDto userDto);
    UserEntity signIn(SignInDto signInDto);
    List<UserEntity> getAllUserList();
    Boolean checkUserRole(UUID id, Role role);
    void delete(UUID id);
    Boolean checkUserBlock(UUID id,Boolean block);
    Boolean update(UUID id, UpdateUserDto updateUserDto);
    UserEntity getById(UUID id);
}
