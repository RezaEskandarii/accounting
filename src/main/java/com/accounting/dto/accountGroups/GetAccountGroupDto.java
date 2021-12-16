package com.accounting.dto.accountGroups;

import com.accounting.dto.BaseDto;
import com.accounting.enums.AccountGroupType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetAccountGroupDto extends BaseDto {

    private String code;

    private String name;

    private AccountGroupType groupType;

}
