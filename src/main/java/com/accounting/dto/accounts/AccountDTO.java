package com.accounting.dto.accounts;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class AccountDTO {

    private String name;

    private String code;

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
