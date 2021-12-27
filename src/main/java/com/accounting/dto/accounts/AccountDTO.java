package com.accounting.dto.accounts;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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

    @Valid
    @NotNull(message = "{account.group_id.required}")
    private Long accountGroupId;
}
