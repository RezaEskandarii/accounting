package com.accounting.domain.entitites;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Data
@Entity
@Table(name = "journals")
public class Journal extends BaseEntity {

    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "memo")
    private String memo;

    @Column(name = "seq")
    private int sequence;

    @JoinColumn(name = "journal_id")
    @OneToMany(targetEntity = Transaction.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Transaction> transactions = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
