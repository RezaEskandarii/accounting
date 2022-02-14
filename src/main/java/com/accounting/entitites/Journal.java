package com.accounting.entitites;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Data
public class Journal extends BaseEntity {

    public Date date;
    public String memo;
    public int sequence;

}
