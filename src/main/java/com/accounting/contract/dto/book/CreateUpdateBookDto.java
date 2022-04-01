package com.accounting.contract.dto.book;

import com.accounting.contract.dto.BaseDto;
import com.accounting.shared.Constants;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Setter
@Getter
public class CreateUpdateBookDto extends BaseDto {

    @Valid
    @Length(min = 1, message = "{book.name.required}")
    private String name;


    @Valid
    @NotNull(message = "{book.startDate.required}")
    @DateTimeFormat(pattern = Constants.dateTimeFormat)
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Valid
    @NotNull(message = "{book.endDate.required}")
    @DateTimeFormat(pattern = Constants.dateTimeFormat)
    @Temporal(TemporalType.DATE)
    private Date endDate;
}
