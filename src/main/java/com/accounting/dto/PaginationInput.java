package com.accounting.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginationInput {

    private int pageNumber;
    private int pageSize;
    private String sortableField;
    private String sortType;
}
