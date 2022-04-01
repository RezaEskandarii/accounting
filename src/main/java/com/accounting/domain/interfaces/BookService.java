package com.accounting.domain.interfaces;

import com.accounting.domain.entitites.Book;

import java.util.Optional;

public interface BookService {

    public Book create(Book book);

    public Book update(Long id, Book book);

    public Optional<Book> find(Long id);

    public void delete(Long id);
}
