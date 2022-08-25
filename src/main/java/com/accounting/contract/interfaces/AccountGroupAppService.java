package com.accounting.contract.interfaces;

import com.accounting.contract.dto.PaginationInput;
import com.accounting.contract.dto.accountGroups.AccountGroupDto;
import org.springframework.data.domain.Page;

public interface AccountGroupAppService {
    public AccountGroupDto create(AccountGroupDto groupDto);

    public AccountGroupDto findById(long id);

    public AccountGroupDto findByCode(String code);

    public AccountGroupDto update(long id, AccountGroupDto groupDto);

    public void delete(long id);

    public Page<AccountGroupDto> findAll(PaginationInput input);
}
