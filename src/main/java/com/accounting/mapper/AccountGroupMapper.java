package com.accounting.mapper;

import com.accounting.dto.accountGroups.GetAccountGroupDto;
import com.accounting.entitites.AccountGroup;
import org.springframework.stereotype.Component;

@Component
public class AccountGroupMapper extends BaseMapper {

    public AccountGroup mapToAccountGroup(Object model) {
        return modelMapper.map(model, AccountGroup.class);
    }

    public GetAccountGroupDto mapToGetAccountGroup(Object model) {
        return modelMapper.map(model, GetAccountGroupDto.class);
    }

    public AccountGroup mapTotAccountGroup(Object model) {
        return modelMapper.map(model, AccountGroup.class);
    }
}

