package com.accounting.application.services;

import com.accounting.contract.dto.book.BookDto;
import com.accounting.contract.dto.book.CreateUpdateBookDto;
import com.accounting.contract.interfaces.BookAppService;
import com.accounting.domain.services.BookServiceImpl;
import com.accounting.shared.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BookAppServiceImpl implements BookAppService {

    @Autowired
    BookServiceImpl bookService;

    @Autowired
    BookMapper bookMapper;

    @Override
    public BookDto create(CreateUpdateBookDto bookDto) {
        var entity = bookMapper.mapToBook(bookDto);
        var result = bookService.create(entity);
        return bookMapper.mapToBookDto(result);
    }

    @Override
    public BookDto update(Long id, CreateUpdateBookDto bookDto) {
        var entity = bookMapper.mapToBook(bookDto);
        var result = bookService.update(id, entity);
        return bookMapper.mapToBookDto(result);
    }

    @Override
    public BookDto find(Long id) {
        var result = bookService.find(id);
        return result.map(book -> bookMapper.mapToBookDto(book)).orElse(null);
    }

    @Override
    public void delete(Long id) {
        bookService.delete(id);
    }
}
