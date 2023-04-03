package com.accounting.domain.entitites;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Setter
@Getter
@Data
@Entity
@Table(name = "transactions")
public class Transaction extends BaseEntity {

    @Column(name = "credit_value")
    private BigDecimal debitValue;

    @Column(name = "debit_value")
    private BigDecimal creditValue;

    @Column(name = "memo")
    private String memo;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne(targetEntity = Journal.class, cascade = CascadeType.ALL)
    private Journal journal;


  ///  @Column(columnDefinition = "jsonb", name = "data")
    private String data;
}
