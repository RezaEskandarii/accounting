package com.accounting.domain.entitites;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Setter
@Getter
@Data
@Entity
@Table(name = "books")
public class Book extends BaseEntity {

    private String name;
    private Date startDate;
    private Date endDate;
}
