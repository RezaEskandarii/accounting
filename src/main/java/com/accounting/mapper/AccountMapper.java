package com.accounting.mapper;

import com.accounting.dto.accounts.AccountDTO;
import com.accounting.dto.accounts.GetAccountDTO;
import com.accounting.entitites.Account;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountMapper extends BaseMapper {

    public AccountMapper() {
        modelMapper = new ModelMapper();
    }

    public Account mapToAccount(Object model) {
        return modelMapper.map(model, Account.class);
    }

    public GetAccountDTO mapToGetAccountDTO(Object model) {

        return modelMapper.map(model, GetAccountDTO.class);
    }

    public AccountDTO mapToAccountDTO(Object model) {

        return modelMapper.map(model, AccountDTO.class);
    }

}
