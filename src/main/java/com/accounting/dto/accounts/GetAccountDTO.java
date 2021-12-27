package com.accounting.dto.accounts;

import com.accounting.dto.BaseDto;
import com.accounting.dto.accountGroups.GetAccountGroupDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAccountDTO extends BaseDto {

    private Long id;

    private String name;

    private String code;

    private int level;

    private boolean isRoot;

    private String description;

    private GetAccountGroupDto accountGroup;
}
