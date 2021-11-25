package com.accounting.entitites;

import org.json.JSONObject;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public JSONObject getMeta() {
        return meta;
    }

    public void setMeta(JSONObject meta) {
        this.meta = meta;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isRoot() {
        return isRoot;
    }

    public void setRoot(boolean root) {
        isRoot = root;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
