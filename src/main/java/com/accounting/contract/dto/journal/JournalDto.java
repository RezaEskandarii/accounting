package com.accounting.contract.dto.journal;

import com.accounting.contract.dto.BaseDto;
import com.accounting.contract.dto.book.BookDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Data
public class JournalDto extends BaseDto {

   // @NotNull
    private Date date ;
    @NotNull
    private String memo;
    @NotNull
    private List<TransactionDto> transactions = new ArrayList<>();
    @NotNull
    private BookDto book;
}
