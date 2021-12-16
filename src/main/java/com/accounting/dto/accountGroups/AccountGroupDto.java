package com.accounting.dto.accountGroups;

import com.accounting.enums.AccountGroupType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
public class AccountGroupDto {

    @Valid
    @Length(min = 2, message = "{account_group.code.min.length}")
    @NotNull(message = "{account_group.code.required}")
    private String code;

    @Valid
    @NotNull(message = "{account_group.name.required}")
    private String name;

    @Valid
    @NotNull(message = "{account_group.type.required}")
    private AccountGroupType groupType;

}
