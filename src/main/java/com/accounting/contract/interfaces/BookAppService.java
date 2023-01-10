package com.accounting.contract.interfaces;

import com.accounting.shared.filters.PaginationInput;
import com.accounting.contract.dto.book.BookDto;
import com.accounting.contract.dto.book.CreateUpdateBookDto;
import org.springframework.data.domain.Page;

public interface BookAppService {

    public BookDto create(CreateUpdateBookDto bookDto);

    public BookDto update(Long id, CreateUpdateBookDto bookDto);

    public BookDto find(Long id);

    public void delete(Long id);

    public Page<BookDto> findAll(PaginationInput input);
}
