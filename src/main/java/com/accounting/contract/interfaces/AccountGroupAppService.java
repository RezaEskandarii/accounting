package com.accounting.contract.interfaces;

import com.accounting.contract.dto.accountGroups.AccountGroupDto;
import com.accounting.shared.filters.PaginationInput;
import org.springframework.data.domain.Page;

public interface AccountGroupAppService {
    AccountGroupDto create(AccountGroupDto groupDto);

    AccountGroupDto findById(long id);

    AccountGroupDto findByCode(String code);

    AccountGroupDto update(long id, AccountGroupDto groupDto);

    void delete(long id);

    Page<AccountGroupDto> findAll(PaginationInput input);
}
