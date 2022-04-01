package com.accounting.contract.dto.book;

import com.accounting.contract.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BookDto extends BaseDto {

    private String name;
    private Date startDate;
    private Date endDate;
}
