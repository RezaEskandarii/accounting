package com.accounting.shared.mapper;

import com.accounting.contract.dto.User.UserCreateDto;
import com.accounting.contract.dto.User.UserDto;
import com.accounting.contract.dto.User.UserUpdateDto;
import com.accounting.domain.entitites.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends BaseMapper {

    public UserDto mapToUserDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    public User mapToUser(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    public User mapToUser(UserUpdateDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    public User mapToUser(UserCreateDto userDto) {
        return modelMapper.map(userDto, User.class);
    }
}
