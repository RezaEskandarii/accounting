package com.accounting.application.services;

import com.accounting.contract.dto.PaginationInput;
import com.accounting.contract.dto.book.BookDto;
import com.accounting.contract.dto.book.CreateUpdateBookDto;
import com.accounting.contract.interfaces.BookAppService;
import com.accounting.domain.interfaces.BookService;
import com.accounting.shared.Constants;
import com.accounting.shared.errors.Errors;
import com.accounting.shared.exceptions.InvalidDataException;
import com.accounting.shared.mapper.BookMapper;
import com.accounting.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BookAppServiceImpl implements BookAppService {

    @Autowired
    BookService bookService;

    @Autowired
    BookMapper bookMapper;

    @Override
    public BookDto create(CreateUpdateBookDto bookDto) {

        validateDateTime(bookDto.getStartDate(), bookDto.getEndDate());

        var entity = bookMapper.mapToBook(bookDto);
        var result = bookService.create(entity);
        return bookMapper.mapToBookDto(result);
    }

    @Override
    public BookDto update(Long id, CreateUpdateBookDto bookDto) {
        validateDateTime(bookDto.getStartDate(), bookDto.getEndDate());

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

    @Override
    public Page<BookDto> findAll(PaginationInput input) {

        var books = bookService.findAll(input);
        return books.map(b -> bookMapper.mapToBookDto(b));
    }

    private void validateDateTime(Date start, Date end) {

        if (DateUtils.getYear(start) > DateUtils.getYear(end)) {
            throw new InvalidDataException().addError(Errors.BOOK_DATE_DURATION_ERROR);
        }

        var difference = DateUtils.getMonthsDifference(end, start);

        if (difference != Constants.bookDateDuration) {
            throw new InvalidDataException().addError(Errors.BOOK_DATE_DURATION_ERROR);
        }
    }
}
