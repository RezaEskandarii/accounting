package com.accounting.domain.entitites;

import com.accounting.shared.enums.AccountGroupType;
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
public class AccountGroup extends BaseEntity {

    @Column(unique = true)
    private String code;

    @Column(length = 125)
    private String name;

    @Column(name = "group_type")
    private AccountGroupType groupType;

    @OneToMany(mappedBy = "accountGroup", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Account> accounts = new ArrayList<>();
}
