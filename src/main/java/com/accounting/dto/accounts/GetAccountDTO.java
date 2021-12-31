package com.accounting.dto.accounts;

import com.accounting.dto.BaseDto;
import com.accounting.dto.accountGroups.GetAccountGroupDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
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