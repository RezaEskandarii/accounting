package com.accounting.contract.interfaces;

import com.accounting.contract.dto.accountGroups.AccountGroupDto;

public interface AccountGroupAppService {
    public AccountGroupDto create(AccountGroupDto groupDto);

    public AccountGroupDto findById(long id);

    public AccountGroupDto findByCode(String code);

    public AccountGroupDto update(long id, AccountGroupDto groupDto);

    public AccountGroupDto delete(long id);
}
