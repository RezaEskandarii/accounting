package com.accounting.shared.mapper;

import com.accounting.contract.dto.accounts.AccountCreateDto;
import com.accounting.contract.dto.accounts.AccountDTO;
import com.accounting.contract.dto.accounts.AccountUpdateDto;
import com.accounting.domain.entitites.Account;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper extends BaseMapper {

    public AccountMapper() {
        modelMapper = new ModelMapper();
    }

    public Account mapToAccount(AccountCreateDto model) {
        return modelMapper.map(model, Account.class);
    }

    public Account mapToAccount(AccountUpdateDto model) {
        return modelMapper.map(model, Account.class);
    }

    public AccountDTO mapToAccountDTO(Account model) {
        return modelMapper.map(model, AccountDTO.class);
    }

}
