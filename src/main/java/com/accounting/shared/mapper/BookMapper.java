package com.accounting.shared.mapper;

import com.accounting.contract.dto.book.BookDto;
import com.accounting.contract.dto.book.CreateUpdateBookDto;
import com.accounting.domain.entitites.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper extends BaseMapper {

    public BookMapper() {
        super();
    }

    public BookDto mapToBookDto(Book book) {
        return modelMapper.map(book, BookDto.class);
    }

    public BookDto mapToBookDto(CreateUpdateBookDto book) {
        return modelMapper.map(book, BookDto.class);
    }

    public Book mapToBook(CreateUpdateBookDto book) {
        return modelMapper.map(book, Book.class);
    }
}
