package com.accounting.entitites;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    @OneToMany(mappedBy = "journal", cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>();

}
