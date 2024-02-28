package com.accounting.domain.interfaces.repository;

import com.accounting.domain.entitites.Book;
import com.accounting.shared.filters.PaginationInput;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface BookRepository {

    Book create(Book book);

    Book update(Long id, Book book);

    Optional<Book> find(Long id);

    void delete(Long id);

    Page<Book> findAll(PaginationInput input);
}
