package com.accounting.entitites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Account extends BaseEntity {

    @Column(length = 256, nullable = false)
    private String name;

    @Column(length = 8, nullable = false, unique = true)
    private String code;

    @Column(nullable = true)
    private int level;

    @Column(nullable = false)
    private boolean isRoot;

    @Column(nullable = true)
    @Lob
    private String description;
}
