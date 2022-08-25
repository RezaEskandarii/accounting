package com.accounting.contract.interfaces;

import com.accounting.contract.dto.PaginationInput;
import com.accounting.contract.dto.accounts.AccountCreateDto;
import com.accounting.contract.dto.accounts.AccountDTO;
import com.accounting.contract.dto.accounts.AccountUpdateDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


public interface AccountAppService {

    public AccountDTO create(AccountCreateDto accountCreateDto);

    public AccountDTO update(Long id, AccountUpdateDto accountUpdateDto);

    public AccountDTO find(Long id);

    public void delete(Long id);

    public Page<AccountDTO> findAll(PaginationInput input);
}
