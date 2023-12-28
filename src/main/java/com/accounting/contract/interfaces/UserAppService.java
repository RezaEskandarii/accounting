package com.accounting.contract.interfaces;

import com.accounting.contract.dto.User.UserDto;
import com.accounting.contract.dto.User.UserUpdateDto;
import com.accounting.domain.entitites.User;

public interface UserAppService {
    UserDto create(UserDto user);

    UserDto update(UserUpdateDto user);

    UserDto toggleStatus(Long userId, boolean enable);

    UserDto changePassword(Long userId, String newPassword);

    void assignRole(Long userId, String roleName);

    void removeRole(Long userId, String roleName);
}
