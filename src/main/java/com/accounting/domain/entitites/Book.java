package com.accounting.domain.entitites;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
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

    @Column(name = "name", nullable = false, length = 255, unique = true)
    private String name;

    @Column(name = "start_date", unique = false)
    private Date startDate;

    @Column(name = "end_date", unique = false)
    private Date endDate;
}
