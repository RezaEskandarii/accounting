package com.accounting.entitites;

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

    private Date date;
    private String memo;
    private int sequence;

    @JoinColumn(name = "journal_id")
    @OneToMany(targetEntity = Transaction.class, cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>();

}
