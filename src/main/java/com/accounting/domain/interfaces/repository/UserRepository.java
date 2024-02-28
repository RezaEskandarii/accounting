package com.accounting.domain.interfaces.repository;

import com.accounting.domain.entitites.User;

public interface UserRepository {
    User create(User user);

    User update(User user);

    User toggleStatus(Long userId, boolean enable);

    User changePassword(Long userId, String newPassword);

    void assignRole(Long userId, String roleName);

    void removeRole(Long userId, String roleName);
}
