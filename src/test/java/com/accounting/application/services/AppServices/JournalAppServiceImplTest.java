package com.accounting.application.services.AppServices;

import com.accounting.contract.dto.journal.JournalDto;
import com.accounting.domain.interfaces.repository.JournalRepository;
import com.accounting.domain.model.Journal;
import com.accounting.shared.filters.PaginationInput;
import com.accounting.shared.mapper.JournalMapper;
import com.accounting.validator.JournalValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class JournalAppServiceImplTest {

    @Mock
    private JournalRepository journalRepository;

    @Mock
    private JournalMapper journalMapper;

    @Mock
    private JournalValidator journalValidator;

    private JournalAppServiceImpl journalAppService;

    @BeforeEach
    void setUp() {
        journalAppService = new JournalAppServiceImpl(journalRepository, journalMapper, journalValidator);
    }

    @Test
    void create_WithValidJournal_ShouldCreateJournal() {
        // Arrange
        JournalDto journalDto = new JournalDto();
        Journal journal = new Journal();
        JournalDto expectedDto = new JournalDto();
        
        when(journalValidator.validate(journalDto)).thenReturn(true);
        when(journalMapper.mapToJournal(journalDto)).thenReturn(journal);
        when(journalRepository.create(journal)).thenReturn(journal);
        when(journalMapper.mapToJournalDTO(journal)).thenReturn(expectedDto);

        // Act
        JournalDto result = journalAppService.create(journalDto);

        // Assert
        assertNotNull(result);
        verify(journalValidator).validate(journalDto);
        verify(journalRepository).create(journal);
        verify(journalMapper).mapToJournalDTO(journal);
    }

    @Test
    void create_WithInvalidJournal_ShouldThrowException() {
        // Arrange
        JournalDto journalDto = new JournalDto();
        when(journalValidator.validate(journalDto)).thenReturn(false);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> journalAppService.create(journalDto));
        verify(journalRepository, never()).create(any());
    }

    @Test
    void update_WithValidJournal_ShouldUpdateJournal() {
        // Arrange
        Long id = 1L;
        JournalDto journalDto = new JournalDto();
        Journal journal = new Journal();
        JournalDto expectedDto = new JournalDto();
        
        when(journalValidator.validate(journalDto)).thenReturn(true);
        when(journalMapper.mapToJournal(journalDto)).thenReturn(journal);
        when(journalRepository.update(eq(id), any(Journal.class))).thenReturn(journal);
        when(journalMapper.mapToJournalDTO(journal)).thenReturn(expectedDto);

        // Act
        JournalDto result = journalAppService.update(id, journalDto);

        // Assert
        assertNotNull(result);
        verify(journalValidator).validate(journalDto);
        verify(journalRepository).update(eq(id), any(Journal.class));
        verify(journalMapper).mapToJournalDTO(journal);
    }

    @Test
    void update_WithInvalidJournal_ShouldThrowException() {
        // Arrange
        Long id = 1L;
        JournalDto journalDto = new JournalDto();
        when(journalValidator.validate(journalDto)).thenReturn(false);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> journalAppService.update(id, journalDto));
        verify(journalRepository, never()).update(any(), any());
    }

    @Test
    void find_ShouldReturnJournal() {
        // Arrange
        Long id = 1L;
        Journal journal = new Journal();
        JournalDto expectedDto = new JournalDto();
        
        when(journalRepository.find(id)).thenReturn(journal);
        when(journalMapper.mapToJournalDTO(journal)).thenReturn(expectedDto);

        // Act
        JournalDto result = journalAppService.find(id);

        // Assert
        assertNotNull(result);
        assertEquals(expectedDto, result);
        verify(journalRepository).find(id);
        verify(journalMapper).mapToJournalDTO(journal);
    }

    @Test
    void delete_ShouldCallRepository() {
        // Arrange
        Long id = 1L;

        // Act
        journalAppService.delete(id);

        // Assert
        verify(journalRepository).delete(id);
    }

    @Test
    void findAll_ShouldReturnPageOfJournals() {
        // Arrange
        PaginationInput input = new PaginationInput();
        Journal journal = new Journal();
        JournalDto journalDto = new JournalDto();
        Page<Journal> journalPage = new PageImpl<>(Arrays.asList(journal));
        
        when(journalRepository.findAll(input)).thenReturn(journalPage);
        when(journalMapper.mapToJournalDTO(journal)).thenReturn(journalDto);

        // Act
        Page<JournalDto> result = journalAppService.findAll(input);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.getContent().size());
        verify(journalRepository).findAll(input);
        verify(journalMapper).mapToJournalDTO(journal);
    }
} 