package com.accounting.contract.dto.accounts;

import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class AccountUpdateDto {
    @Valid
    @Length(min = 2, message = "{account.name.required}")
    private String name;

    @Valid
    @Length(min = 4, max = 4, message = "{account.code.min.length}")
    private String code;

    private boolean isRoot;

    private String description;

    @Valid
    @NotNull(message = "{account.group_id.required}")
    private Long accountGroupId;
}
