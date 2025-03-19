package com.accounting.application.services.AppServices;

import com.accounting.contract.dto.book.BookDto;
import com.accounting.contract.dto.book.CreateUpdateBookDto;
import com.accounting.domain.interfaces.repository.BookRepository;
import com.accounting.domain.model.Book;
import com.accounting.shared.Constants;
import com.accounting.shared.exceptions.InvalidDataException;
import com.accounting.shared.exceptions.ItemNotFoundException;
import com.accounting.shared.filters.PaginationInput;
import com.accounting.shared.mapper.BookMapper;
import com.accounting.utils.DateUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BookAppServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BookMapper bookMapper;

    private BookAppServiceImpl bookAppService;

    @BeforeEach
    void setUp() {
        bookAppService = new BookAppServiceImpl(bookRepository, bookMapper);
    }

    @Test
    void create_WithValidDates_ShouldCreateBook() {
        // Arrange
        CreateUpdateBookDto createDto = new CreateUpdateBookDto();
        Calendar cal = Calendar.getInstance();
        cal.set(2024, Calendar.JANUARY, 1);
        Date startDate = cal.getTime();
        cal.add(Calendar.MONTH, Constants.bookDateDuration);
        Date endDate = cal.getTime();
        
        createDto.setStartDate(startDate);
        createDto.setEndDate(endDate);
        
        Book book = new Book();
        BookDto expectedDto = new BookDto();
        
        when(bookMapper.mapToBook(any(CreateUpdateBookDto.class))).thenReturn(book);
        when(bookRepository.create(any(Book.class))).thenReturn(book);
        when(bookMapper.mapToBookDto(any(Book.class))).thenReturn(expectedDto);

        // Act
        BookDto result = bookAppService.create(createDto);

        // Assert
        assertNotNull(result);
        verify(bookRepository).create(book);
        verify(bookMapper).mapToBookDto(book);
    }

    @Test
    void create_WithInvalidDateDuration_ShouldThrowException() {
        // Arrange
        CreateUpdateBookDto createDto = new CreateUpdateBookDto();
        Calendar cal = Calendar.getInstance();
        cal.set(2024, Calendar.JANUARY, 1);
        Date startDate = cal.getTime();
        cal.add(Calendar.MONTH, Constants.bookDateDuration + 1); // Invalid duration
        Date endDate = cal.getTime();
        
        createDto.setStartDate(startDate);
        createDto.setEndDate(endDate);

        // Act & Assert
        assertThrows(InvalidDataException.class, () -> bookAppService.create(createDto));
        verify(bookRepository, never()).create(any());
    }

    @Test
    void update_WithValidData_ShouldUpdateBook() {
        // Arrange
        Long id = 1L;
        CreateUpdateBookDto updateDto = new CreateUpdateBookDto();
        Calendar cal = Calendar.getInstance();
        cal.set(2024, Calendar.JANUARY, 1);
        Date startDate = cal.getTime();
        cal.add(Calendar.MONTH, Constants.bookDateDuration);
        Date endDate = cal.getTime();
        
        updateDto.setStartDate(startDate);
        updateDto.setEndDate(endDate);
        
        Book existingBook = new Book();
        Book updatedBook = new Book();
        BookDto expectedDto = new BookDto();
        
        when(bookRepository.find(id)).thenReturn(Optional.of(existingBook));
        when(bookMapper.mapToBook(any(CreateUpdateBookDto.class))).thenReturn(updatedBook);
        when(bookRepository.update(eq(id), any(Book.class))).thenReturn(updatedBook);
        when(bookMapper.mapToBookDto(any(Book.class))).thenReturn(expectedDto);

        // Act
        BookDto result = bookAppService.update(id, updateDto);

        // Assert
        assertNotNull(result);
        verify(bookRepository).update(eq(id), any(Book.class));
        verify(bookMapper).mapToBookDto(updatedBook);
    }

    @Test
    void update_WithNonExistentId_ShouldThrowException() {
        // Arrange
        Long id = 1L;
        CreateUpdateBookDto updateDto = new CreateUpdateBookDto();
        when(bookRepository.find(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ItemNotFoundException.class, () -> bookAppService.update(id, updateDto));
        verify(bookRepository, never()).update(any(), any());
    }

    @Test
    void find_WithExistingId_ShouldReturnBook() {
        // Arrange
        Long id = 1L;
        Book book = new Book();
        BookDto expectedDto = new BookDto();
        
        when(bookRepository.find(id)).thenReturn(Optional.of(book));
        when(bookMapper.mapToBookDto(book)).thenReturn(expectedDto);

        // Act
        BookDto result = bookAppService.find(id);

        // Assert
        assertNotNull(result);
        assertEquals(expectedDto, result);
    }

    @Test
    void find_WithNonExistentId_ShouldThrowException() {
        // Arrange
        Long id = 1L;
        when(bookRepository.find(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ItemNotFoundException.class, () -> bookAppService.find(id));
    }

    @Test
    void delete_ShouldCallRepository() {
        // Arrange
        Long id = 1L;

        // Act
        bookAppService.delete(id);

        // Assert
        verify(bookRepository).delete(id);
    }

    @Test
    void findAll_ShouldReturnPageOfBooks() {
        // Arrange
        PaginationInput input = new PaginationInput();
        Book book = new Book();
        BookDto bookDto = new BookDto();
        Page<Book> bookPage = new PageImpl<>(Arrays.asList(book));
        
        when(bookRepository.findAll(input)).thenReturn(bookPage);
        when(bookMapper.mapToBookDto(book)).thenReturn(bookDto);

        // Act
        Page<BookDto> result = bookAppService.findAll(input);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.getContent().size());
        verify(bookRepository).findAll(input);
        verify(bookMapper).mapToBookDto(book);
    }
} 