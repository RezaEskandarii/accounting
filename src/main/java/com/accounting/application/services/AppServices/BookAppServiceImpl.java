package com.accounting.application.services.AppServices;

import com.accounting.contract.dto.book.BookDto;
import com.accounting.contract.dto.book.CreateUpdateBookDto;
import com.accounting.contract.interfaces.appservices.BookAppService;
import com.accounting.domain.interfaces.repository.BookRepository;
import com.accounting.shared.Constants;
import com.accounting.shared.errors.Errors;
import com.accounting.shared.exceptions.InvalidDataException;
import com.accounting.shared.exceptions.ItemNotFoundException;
import com.accounting.shared.filters.PaginationInput;
import com.accounting.shared.mapper.BookMapper;
import com.accounting.utils.DateUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BookAppServiceImpl implements BookAppService {


    final BookRepository bookService;


    final BookMapper bookMapper;

    public BookAppServiceImpl(BookRepository bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @Override
    public BookDto create(CreateUpdateBookDto bookDto) {

        validateDateTime(bookDto.getStartDate(), bookDto.getEndDate());

        var entity = bookMapper.mapToBook(bookDto);
        var result = bookService.create(entity);
        return bookMapper.mapToBookDto(result);
    }

    @Override
    public BookDto update(Long id, CreateUpdateBookDto bookDto) {

        bookService.find(id).orElseThrow(() -> new ItemNotFoundException(1));

        validateDateTime(bookDto.getStartDate(), bookDto.getEndDate());

        var entity = bookMapper.mapToBook(bookDto);
        var result = bookService.update(id, entity);
        return bookMapper.mapToBookDto(result);
    }

    @Override
    public BookDto find(Long id) {
        var result = bookService.find(id);
        return result.map(book -> bookMapper.mapToBookDto(book)).orElseThrow(() -> new ItemNotFoundException(1));
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
