package com.accounting.application.services;

import com.accounting.contract.dto.User.UserDto;
import com.accounting.contract.dto.User.UserUpdateDto;
import com.accounting.contract.interfaces.UserAppService;
import com.accounting.domain.interfaces.UserRepository;
import com.accounting.shared.mapper.UserMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAppServiceImpl implements UserAppService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserAppServiceImpl(UserMapper userMapper, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UserDto create(UserDto user) {
        var result = userRepository.create(userMapper.mapToUser(user));
        return userMapper.mapToUserDto(result);
    }

    @Override
    public UserDto update(UserUpdateDto user) {
        var result = userRepository.create(userMapper.mapToUser(user));
        return userMapper.mapToUserDto(result);
    }

    @Override
    public UserDto toggleStatus(Long userId, boolean enable) {
        var result = userRepository.toggleStatus(userId, enable);
        return userMapper.mapToUserDto(result);
    }

    @Override
    public UserDto changePassword(Long userId, String newPassword) {
        var encodedPassword = passwordEncoder.encode(newPassword);
        var result = userRepository.changePassword(userId, encodedPassword);
        return userMapper.mapToUserDto(result);
    }

    @Override
    public void assignRole(Long userId, String roleName) {
        userRepository.assignRole(userId, roleName);
    }

    @Override
    public void removeRole(Long userId, String roleName) {
        userRepository.removeRole(userId, roleName);
    }
}