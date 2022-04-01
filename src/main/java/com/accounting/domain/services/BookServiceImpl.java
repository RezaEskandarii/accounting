package com.accounting.domain.services;

import com.accounting.contract.dto.PaginationInput;
import com.accounting.domain.entitites.Book;
import com.accounting.domain.interfaces.BookService;
import com.accounting.repositories.interfaces.BookRepository;
import com.accounting.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(Long id, Book book) {
        book.id = id;
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> find(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Page<Book> findAll(PaginationInput input) {

        return bookRepository.findAll(PageUtils.GetRequest(input));
    }
}
