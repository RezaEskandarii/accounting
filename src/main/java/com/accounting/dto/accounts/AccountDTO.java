package com.accounting.dto.accounts;

import com.accounting.dto.accountGroups.AccountGroupDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;

@Setter
@Getter
@Data
public class AccountDTO {

    @Valid
    @Length(min = 2, message = "{account.name.required}")
    private String name;

    @Valid
    @Length(min = 4, max = 4, message = "{account.code.min.length}")
    private String code;

    private boolean isRoot;

    private String description;

    AccountGroupDto accountGroup;
}
