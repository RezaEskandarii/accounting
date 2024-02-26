package com.accounting.contract.interfaces.appservices;

import com.accounting.contract.dto.accounts.AccountCreateDto;
import com.accounting.contract.dto.accounts.AccountDTO;
import com.accounting.contract.dto.accounts.AccountUpdateDto;
import com.accounting.shared.filters.PaginationInput;
import org.springframework.data.domain.Page;


public interface AccountAppService {

    AccountDTO create(AccountCreateDto accountCreateDto);

    AccountDTO update(Long id, AccountUpdateDto accountUpdateDto);

    AccountDTO find(Long id);

    void delete(Long id);

    Page<AccountDTO> findAll(PaginationInput input);
}
