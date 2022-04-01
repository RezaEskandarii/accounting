package com.accounting.contract.dto.accounts;

import com.accounting.contract.dto.BaseDto;
import com.accounting.contract.dto.accountGroups.GetAccountGroupDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetAccountDTO extends BaseDto {

    private String name;

    private String code;

    private int level;

    private boolean isRoot;

    private String description;

    private GetAccountGroupDto accountGroup;

}