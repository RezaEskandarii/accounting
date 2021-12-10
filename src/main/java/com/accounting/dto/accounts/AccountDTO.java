package com.accounting.dto.accounts;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Setter
@Getter
@Data
public class AccountDTO {

    @Valid
    @Min(value = 2, message = "{account.name.required}")
    private String name;

    @Valid
    @Min(value = 4, message = "{account.code.min.length}")
    @Max(value = 4, message = "{account.code.max.length}")
    private String code;

    private boolean isRoot;

    private String description;

    @Override
    public String toString() {
        return "AccountDTO{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", isRoot=" + isRoot +
                ", description='" + description + '\'' +
                '}';
    }
}
