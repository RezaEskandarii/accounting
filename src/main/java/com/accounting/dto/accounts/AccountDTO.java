package com.accounting.dto.accounts;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Setter
@Getter
@Data
public class AccountDTO {

    @Min(2)
    private String name;

    @Min(4)
    @Max(4)
    private String code;

    @Min(0)
    private int level;

    private boolean isRoot;

    private String description;

    @Override
    public String toString() {
        return "AccountDTO{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", level=" + level +
                ", isRoot=" + isRoot +
                ", description='" + description + '\'' +
                '}';
    }
}
