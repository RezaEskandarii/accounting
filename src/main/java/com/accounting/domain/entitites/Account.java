package com.accounting.domain.entitites;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@EqualsAndHashCode(callSuper = true)
@Setter
@Getter
@Entity
@Data
@Table(name = "accounts")
public class Account extends BaseEntity {

    @Column(length = 256, nullable = false, unique = true)
    private String name;

    @Column(length = 8, nullable = false, unique = true)
    private String code;

    @Column(nullable = true)
    private int level;

    @Column(nullable = false, name = "is_root")
    private boolean isRoot;

    @Column(nullable = true)
    @Lob
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_group_id")
    private AccountGroup accountGroup;

}
