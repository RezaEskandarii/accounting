package com.accounting.entitites;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Setter
@Getter
@Data
public class Book extends BaseEntity {

    private String name;
    private Date startDate;
    private Date endDate;
}
