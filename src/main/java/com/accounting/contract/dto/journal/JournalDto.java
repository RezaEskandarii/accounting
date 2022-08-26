package com.accounting.contract.dto.journal;

import com.accounting.contract.dto.BaseDto;
import com.accounting.contract.dto.book.BookDto;
import com.accounting.domain.entitites.Transaction;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Data
public class JournalDto extends BaseDto {

    private Date date;
    private String memo;
    private int sequence;
    private List<TransactionDto> transactions = new ArrayList<>();
    private BookDto book;
}
