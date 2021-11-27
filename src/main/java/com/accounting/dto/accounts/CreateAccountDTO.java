package com.accounting.dto.accounts;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class CreateAccountDTO {

    private String name;

    private String code;

    private AppJSON meta;

    private int level;

    private boolean isRoot;

    private String description;
}
