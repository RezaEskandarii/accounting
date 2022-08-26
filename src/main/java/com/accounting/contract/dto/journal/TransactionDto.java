package com.accounting.contract.dto.journal;

import com.accounting.contract.dto.BaseDto;
import com.accounting.contract.dto.accounts.AccountDTO;
import com.accounting.contract.dto.book.BookDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
public class TransactionDto extends BaseDto {

    private BigDecimal debitValue;
    private BigDecimal creditValue;
    private String memo;
    private AccountDTO account;
    private BookDto book;
}
