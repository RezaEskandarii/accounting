package com.accounting.mapper;

import com.accounting.dto.accounts.AccountDTO;
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

        if (model instanceof AccountDTO) {
            return modelMapper.map(model, Account.class);
        }

        throw new RuntimeException("given model type is not of the dto");
    }


    public AccountDTO mapToAccountDTO(Object model) {

        if (model instanceof Account) {
            return modelMapper.map(model, AccountDTO.class);
        }

        throw new RuntimeException("given model type is not of the dto");
    }


    public List<AccountDTO> mapToAccountDTOCollection(List<Account> accounts) {
        return mapList(accounts, AccountDTO.class);
    }
}
