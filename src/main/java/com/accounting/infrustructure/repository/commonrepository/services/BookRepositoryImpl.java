package com.accounting.infrustructure.repository.commonrepository.services;

import com.accounting.domain.entitites.Book;
import com.accounting.domain.interfaces.repository.BookRepository;
import com.accounting.infrustructure.repository.jparepository.BookJpaRepository;
import com.accounting.infrustructure.repository.jparepository.TransactionJpaRepository;
import com.accounting.shared.errors.Errors;
import com.accounting.shared.exceptions.ConflictException;
import com.accounting.shared.filters.PaginationInput;
import com.accounting.utils.PageUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookRepositoryImpl implements BookRepository {


    private final BookJpaRepository bookRepository;

    private final TransactionJpaRepository transactionRepository;

    public BookRepositoryImpl(BookJpaRepository bookRepository, TransactionJpaRepository transactionRepository) {
        this.bookRepository = bookRepository;
        this.transactionRepository = transactionRepository;
    }

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

        if (transactionRepository.countByBook(id) > 0) {
            throw new ConflictException().addError(Errors.BOOK_HAS_TRANSACTION_ERROR);
        }

        bookRepository.deleteById(id);
    }

    @Override
    public Page<Book> findAll(PaginationInput input) {

        return bookRepository.findAll(PageUtils.GetRequest(input));
    }
}
