package com.accounting.contract.dto.accountGroups;

import com.accounting.contract.dto.BaseDto;
import com.accounting.shared.enums.AccountGroupType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetAccountGroupDto extends BaseDto {

    private String code;

    private String name;

    private AccountGroupType groupType;

}
