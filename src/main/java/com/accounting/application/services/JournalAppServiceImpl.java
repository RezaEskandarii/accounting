package com.accounting.application.services;

import com.accounting.contract.dto.journal.JournalDto;
import com.accounting.contract.interfaces.JournalAppService;
import com.accounting.domain.interfaces.JournalRepository;
import com.accounting.shared.filters.PaginationInput;
import com.accounting.shared.mapper.JournalMapper;
import com.accounting.validator.JournalValidator;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class JournalAppServiceImpl implements JournalAppService {


    private final JournalRepository journalService;

    private final JournalMapper journalMapper;

    private final JournalValidator journalValidator;

    public JournalAppServiceImpl(JournalRepository journalService, JournalMapper journalMapper, JournalValidator journalValidator) {
        this.journalService = journalService;
        this.journalMapper = journalMapper;
        this.journalValidator = journalValidator;
    }

    @Override
    public JournalDto create(JournalDto dto) {
        if (!journalValidator.validate(dto)) {
            throw new IllegalArgumentException();
        }

        var entity = journalMapper.mapToJournal(dto);
        return journalMapper.mapToJournalDTO(journalService.create(entity));
    }

    @Override
    public JournalDto update(Long id, JournalDto dto) {

        if (!journalValidator.validate(dto)) {
            throw new IllegalArgumentException();
        }

        var entity = journalMapper.mapToJournal(dto);
        entity.id = id;
        return journalMapper.mapToJournalDTO(journalService.update(id, entity));
    }

    @Override
    public JournalDto find(Long id) {
        return journalMapper.mapToJournalDTO(journalService.find(id));
    }

    @Override
    public void delete(Long id) {
        journalService.delete(id);
    }

    @Override
    public Page<JournalDto> findAll(PaginationInput input) {
        var journals = journalService.findAll(input);
        return journals.map(x -> journalMapper.mapToJournalDTO(x));
    }
}
