package com.accounting.entitites;

import lombok.*;
import org.json.JSONObject;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Account extends BaseEntity {

    @Column(length = 256, nullable = false)
    private String name;

    @Column(length = 8, nullable = false)
    private String code;

    @Column(columnDefinition = "json")
    @Convert(converter = JSONObjectConverter.class)
    private JSONObject meta;

    @Column(nullable = true)
    private int level;

    @Column(nullable = false)
    private boolean isRoot;

    @Column(nullable = true)
    @Lob
    private String description;
}
