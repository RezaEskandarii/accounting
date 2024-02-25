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

    public AccountGroup mapToAccountGroup(AccountGroupDto model) {
        return modelMapper.map(model, AccountGroup.class);
    }

    public GetAccountGroupDto mapToGetAccountGroup(AccountGroup model) {
        return modelMapper.map(model, GetAccountGroupDto.class);
    }

    public AccountGroupDto mapToAccountGroupDto(AccountGroup model) {
        return modelMapper.map(model, AccountGroupDto.class);
    }
}

