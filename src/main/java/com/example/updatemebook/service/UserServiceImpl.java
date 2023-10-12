package com.example.updatemebook.service;

import com.example.updatemebook.controller.dto.SignInDto;
import com.example.updatemebook.controller.dto.UpdateUserDto;
import com.example.updatemebook.controller.dto.UserDto;
import com.example.updatemebook.entity.user.Role;
import com.example.updatemebook.entity.user.UserEntity;
import com.example.updatemebook.errors.AuthenticationFailedException;
import com.example.updatemebook.errors.UserNotFoundException;
import com.example.updatemebook.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    public final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Override
    public UserEntity save(UserDto userDto){
        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
        userEntity.setRole(Role.USER);
        userEntity.setBlock(false);
        userEntity.setSecure(false);
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity signIn(SignInDto signInDto) {
        return userRepository.findByUsernameAndPassword(signInDto.getUsername(),signInDto.getPassword());
    }

    @Override
    public List<UserEntity> getAllUserList() {
        return userRepository.findAll();
    }

    @Override
    public Boolean checkUserRole(UUID id, Role role) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found?")
        );
        userEntity.setRole(role);
        return true;
    }

    @Override
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public Boolean checkUserBlock(UUID id, Boolean block) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found?")
        );
        userEntity.setBlock(block);
        return true;
    }

    @Override
    public Boolean update(UUID id, UpdateUserDto updateUserDto) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found?")
        );
        userEntity.setName(updateUserDto.getName());
        userEntity.setUsername(updateUserDto.getUsername());
        userEntity.setPassword(updateUserDto.getPassword());
        userRepository.save(userEntity);
        return true;
    }

    @Override
    public UserEntity getById(UUID id) {
        return userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("Bobur user not found")
        );
    }

}
