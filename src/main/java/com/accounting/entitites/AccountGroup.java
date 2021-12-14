package com.accounting.entitites;

import com.accounting.enums.AccountGroupType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Setter
@Getter
public class AccountGroup extends BaseEntity {

    private String code;
    private String name;
    private AccountGroupType groupType;
}
