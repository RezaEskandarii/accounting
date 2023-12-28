package com.accounting.domain.repositories;

import com.accounting.crudrepositories.interfaces.RoleCrudRepository;
import com.accounting.crudrepositories.interfaces.UserCrudRepository;
import com.accounting.domain.entitites.Role;
import com.accounting.domain.entitites.User;
import org.webjars.NotFoundException;

public class UserRepository implements com.accounting.domain.interfaces.UserRepository {

    private final UserCrudRepository userCrudRepository;
    private final RoleCrudRepository roleCrudRepository;

    public UserRepository(UserCrudRepository userCrudRepository, RoleCrudRepository roleCrudRepository) {
        this.userCrudRepository = userCrudRepository;
        this.roleCrudRepository = roleCrudRepository;
    }

    @Override
    public User create(User user) {
        return userCrudRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userCrudRepository.save(user);
    }

    @Override
    public User toggleStatus(Long userId, boolean enable) {
        User user = userCrudRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found with ID: " + userId));

        user.setEnabled(!user.isEnabled());

        return userCrudRepository.save(user);
    }

    @Override
    public User changePassword(Long userId, String newPassword) {
        User user = userCrudRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found with ID: " + userId));

        user.setPassword(newPassword);

        return userCrudRepository.save(user);
    }

    @Override
    public void assignRole(Long userId, String roleName) {
        User user = userCrudRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found with ID: " + userId));

        Role role = roleCrudRepository.findByName(roleName)
                .orElseThrow(() -> new NotFoundException("Role not found with Name: " + roleName));

        user.addRole(role);
        userCrudRepository.save(user);
    }

    @Override
    public void removeRole(Long userId, String roleName) {
        User user = userCrudRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found with ID: " + userId));

        Role role = user.getRoles().stream()
                .filter(r -> r.getName().equals(roleName))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Role not found with Name: " + roleName));

        user.removeRole(role);
        userCrudRepository.save(user);
    }
}
