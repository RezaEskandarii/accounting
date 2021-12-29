package com.accounting.entitites;

import com.accounting.enums.AccountGroupType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@Entity
public class AccountGroup extends BaseEntity {

    @Column(unique = true)
    private String code;

    @Column(unique = true, length = 125)
    private String name;

    private AccountGroupType groupType;

    @OneToMany(mappedBy = "accountGroup", fetch = FetchType.LAZY)
    private List<Account> accounts = new ArrayList<>();
}
