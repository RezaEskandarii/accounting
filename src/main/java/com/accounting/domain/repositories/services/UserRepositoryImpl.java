package com.accounting.domain.repositories.services;

import com.accounting.domain.entitites.Role;
import com.accounting.domain.entitites.User;
import com.accounting.domain.interfaces.UserRepository;
import com.accounting.jparepository.RoleJpaRepository;
import com.accounting.jparepository.UserJpaRepository;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

@Component
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userCrudRepository;
    private final RoleJpaRepository roleCrudRepository;

    public UserRepositoryImpl(UserJpaRepository userCrudRepository, RoleJpaRepository roleCrudRepository) {
        this.userCrudRepository = userCrudRepository;
        this.roleCrudRepository = roleCrudRepository;
    }

    @Override
    public User create(User user) {
        user.setUsername(user.getEmail());
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
