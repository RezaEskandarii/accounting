package com.accounting.mapper;

import com.accounting.dto.accounts.CreateAccountDTO;
import com.accounting.entitites.Account;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public Account MapToAccount(Object model) {
        ModelMapper modelMapper = new ModelMapper();

        if (model instanceof CreateAccountDTO) {
            return modelMapper.map(model, Account.class);
        }

        throw new RuntimeException("given model type is not of the dto");
    }
}
