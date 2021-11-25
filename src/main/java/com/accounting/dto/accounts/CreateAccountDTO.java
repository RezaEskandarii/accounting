package com.accounting.dto.accounts;

import org.json.JSONObject;

public class CreateAccountDTO {

    private String name;

    private String code;

    private JSONObject meta;

    private int level;

    private boolean isRoot;

    private String description;
}
