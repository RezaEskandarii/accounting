package com.accounting.application.services.AppServices;

import com.accounting.contract.dto.User.UserCreateDto;
import com.accounting.contract.dto.User.UserDto;
import com.accounting.contract.dto.User.UserUpdateDto;
import com.accounting.domain.interfaces.repository.UserRepository;
import com.accounting.domain.model.User;
import com.accounting.shared.mapper.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserAppServiceImplTest {

    @Mock
    private UserMapper userMapper;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    private UserAppServiceImpl userAppService;

    @BeforeEach
    void setUp() {
        userAppService = new UserAppServiceImpl(userMapper, userRepository, passwordEncoder);
    }

    @Test
    void create_ShouldEncodePasswordAndSaveUser() {
        // Arrange
        UserCreateDto createDto = new UserCreateDto();
        createDto.setPassword("password");
        User user = new User();
        UserDto expectedDto = new UserDto();
        
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        when(userMapper.mapToUser(any(UserCreateDto.class))).thenReturn(user);
        when(userRepository.create(any(User.class))).thenReturn(user);
        when(userMapper.mapToUserDto(any(User.class))).thenReturn(expectedDto);

        // Act
        UserDto result = userAppService.create(createDto);

        // Assert
        assertNotNull(result);
        verify(passwordEncoder).encode("password");
        verify(userRepository).create(user);
        verify(userMapper).mapToUserDto(user);
    }

    @Test
    void update_ShouldUpdateAndReturnUser() {
        // Arrange
        UserUpdateDto updateDto = new UserUpdateDto();
        User user = new User();
        UserDto expectedDto = new UserDto();
        
        when(userMapper.mapToUser(any(UserUpdateDto.class))).thenReturn(user);
        when(userRepository.create(any(User.class))).thenReturn(user);
        when(userMapper.mapToUserDto(any(User.class))).thenReturn(expectedDto);

        // Act
        UserDto result = userAppService.update(updateDto);

        // Assert
        assertNotNull(result);
        verify(userRepository).create(user);
        verify(userMapper).mapToUserDto(user);
    }

    @Test
    void toggleStatus_ShouldToggleUserStatus() {
        // Arrange
        Long userId = 1L;
        boolean enable = true;
        User user = new User();
        UserDto expectedDto = new UserDto();
        
        when(userRepository.toggleStatus(userId, enable)).thenReturn(user);
        when(userMapper.mapToUserDto(any(User.class))).thenReturn(expectedDto);

        // Act
        UserDto result = userAppService.toggleStatus(userId, enable);

        // Assert
        assertNotNull(result);
        verify(userRepository).toggleStatus(userId, enable);
        verify(userMapper).mapToUserDto(user);
    }

    @Test
    void changePassword_ShouldEncodeAndUpdatePassword() {
        // Arrange
        Long userId = 1L;
        String newPassword = "newPassword";
        String encodedPassword = "encodedPassword";
        
        when(passwordEncoder.encode(newPassword)).thenReturn(encodedPassword);

        // Act
        userAppService.changePassword(userId, newPassword);

        // Assert
        verify(passwordEncoder).encode(newPassword);
        verify(userRepository).changePassword(userId, encodedPassword);
    }

    @Test
    void assignRole_ShouldAssignRoleToUser() {
        // Arrange
        Long userId = 1L;
        String roleName = "ROLE_ADMIN";

        // Act
        userAppService.assignRole(userId, roleName);

        // Assert
        verify(userRepository).assignRole(userId, roleName);
    }

    @Test
    void removeRole_ShouldRemoveRoleFromUser() {
        // Arrange
        Long userId = 1L;
        String roleName = "ROLE_ADMIN";

        // Act
        userAppService.removeRole(userId, roleName);

        // Assert
        verify(userRepository).removeRole(userId, roleName);
    }
} 