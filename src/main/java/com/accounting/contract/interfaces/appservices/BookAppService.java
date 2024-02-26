package com.accounting.contract.interfaces.appservices;

import com.accounting.contract.dto.book.BookDto;
import com.accounting.contract.dto.book.CreateUpdateBookDto;
import com.accounting.shared.filters.PaginationInput;
import org.springframework.data.domain.Page;

public interface BookAppService {

    BookDto create(CreateUpdateBookDto bookDto);

    BookDto update(Long id, CreateUpdateBookDto bookDto);

    BookDto find(Long id);

    void delete(Long id);

    Page<BookDto> findAll(PaginationInput input);
}
