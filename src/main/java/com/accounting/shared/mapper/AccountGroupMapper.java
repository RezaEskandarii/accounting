package com.accounting.shared.mapper;

import com.accounting.contract.dto.accountGroups.AccountGroupDto;
import com.accounting.contract.dto.accountGroups.GetAccountGroupDto;
import com.accounting.domain.entitites.AccountGroup;
import org.springframework.stereotype.Component;

@Component
public class AccountGroupMapper extends BaseMapper {

    public AccountGroupMapper() {
        super();
    }

    public AccountGroup mapToAccountGroup(Object model) {
        return modelMapper.map(model, AccountGroup.class);
    }

    public GetAccountGroupDto mapToGetAccountGroup(Object model) {
        return modelMapper.map(model, GetAccountGroupDto.class);
    }

    public AccountGroup mapTotAccountGroup(Object model) {
        return modelMapper.map(model, AccountGroup.class);
    }

    public AccountGroupDto mapToAccountGroupDto(Object model) {
        return modelMapper.map(model, AccountGroupDto.class);
    }
}

