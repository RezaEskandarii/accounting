package com.accounting.contract.interfaces;

import com.accounting.contract.dto.User.UserCreateDto;
import com.accounting.contract.dto.User.UserDto;
import com.accounting.contract.dto.User.UserUpdateDto;

public interface UserAppService {
    UserDto create(UserCreateDto user);

    UserDto update(UserUpdateDto user);

    UserDto toggleStatus(Long userId, boolean enable);

     void changePassword(Long userId, String newPassword);

    void assignRole(Long userId, String roleName);

    void removeRole(Long userId, String roleName);
}
