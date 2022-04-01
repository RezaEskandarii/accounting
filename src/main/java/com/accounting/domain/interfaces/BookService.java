package com.accounting.domain.interfaces;

import com.accounting.contract.dto.PaginationInput;
import com.accounting.contract.dto.book.BookDto;
import com.accounting.domain.entitites.Account;
import com.accounting.domain.entitites.Book;
import com.accounting.utils.PageUtils;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface BookService {

    public Book create(Book book);

    public Book update(Long id, Book book);

    public Optional<Book> find(Long id);

    public void delete(Long id);

    public Page<Book> findAll(PaginationInput input);
}
