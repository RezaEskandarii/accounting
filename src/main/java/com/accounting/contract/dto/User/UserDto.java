package com.accounting.contract.dto.User;

import com.accounting.contract.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto extends BaseDto {
    private Long id;
    private String username;
    private String password;
    private boolean enabled;
}
