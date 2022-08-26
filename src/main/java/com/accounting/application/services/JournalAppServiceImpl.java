package com.accounting.application.services;

import com.accounting.contract.dto.PaginationInput;
import com.accounting.contract.dto.journal.JournalDto;
import com.accounting.contract.interfaces.JournalAppService;
import com.accounting.domain.interfaces.JournalService;
import com.accounting.shared.mapper.JournalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

public class JournalAppServiceImpl implements JournalAppService {

    @Autowired
    private JournalService journalService;

    @Autowired
    private JournalMapper journalMapper;


    @Override
    public JournalDto create(JournalDto dto) {
        var entity = journalMapper.mapToJournal(dto);
        return journalMapper.mapToJournalDTO(
                journalService.create(entity)
        );
    }

    @Override
    public JournalDto update(Long id, JournalDto dto) {
        var entity = journalMapper.mapToJournal(dto);
        entity.id = id;
        return journalMapper.mapToJournalDTO(
                journalService.update(id, entity)
        );
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
        return journals.map(j -> journalMapper.mapToJournalDTO(j));
    }
}
