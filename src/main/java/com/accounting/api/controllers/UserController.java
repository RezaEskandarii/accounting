package com.accounting.api.controllers;


import com.accounting.commons.ApiResponse;
import com.accounting.config.APIConfig;
import com.accounting.contract.dto.User.UserCreateDto;
import com.accounting.contract.dto.User.UserUpdateDto;
import com.accounting.contract.interfaces.appservices.UserAppService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping(APIConfig.USERS_CONTROLLER)

public class UserController extends BaseController {

    private final UserAppService userService;

    public UserController(UserAppService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody UserCreateDto user) {
        var createdUser = userService.create(user);
        return ResponseEntity.ok(new ApiResponse(createdUser));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<ApiResponse> update(@PathVariable Long userId, @RequestBody UserUpdateDto userUpdateDto) {
        userUpdateDto.setId(userId);
        var updatedUser = userService.update(userUpdateDto);
        return ResponseEntity.ok(new ApiResponse(updatedUser));
    }

    @PatchMapping("/{userId}/status")
    public ResponseEntity<ApiResponse> toggleUserStatus(@PathVariable Long userId, @RequestParam boolean enable) {
        userService.toggleStatus(userId, enable);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{userId}/password")
    public ResponseEntity<ApiResponse> changePassword(@PathVariable Long userId, @RequestParam String newPassword) {
        userService.changePassword(userId, newPassword);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{userId}/assign-role")
    public ResponseEntity<ApiResponse> assignRole(@PathVariable Long userId, @RequestParam String roleName) {
        userService.assignRole(userId, roleName);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{userId}/remove-role")
    public ResponseEntity<ApiResponse> removeRole(@PathVariable Long userId, @RequestParam String roleName) {
        userService.removeRole(userId, roleName);
        return ResponseEntity.ok().build();
    }
}
