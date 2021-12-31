package com.accounting.entitites;

import com.accounting.enums.AccountGroupType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@Entity
@Table(name = "account_groups")
public class AccountGroup extends BaseEntity{

    @Column(unique = true)
    private String code;

    @Column(unique = true, length = 125)
    private String name;

    private AccountGroupType groupType;

    @OneToMany(mappedBy = "accountGroup", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Account> accounts = new ArrayList<>();
}
