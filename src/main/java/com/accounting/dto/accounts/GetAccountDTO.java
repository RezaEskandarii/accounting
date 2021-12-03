package com.accounting.dto.accounts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAccountDTO {

    private Long id;

    private String name;

    private String code;

    private int level;

    private boolean isRoot;

    private String description;

}
