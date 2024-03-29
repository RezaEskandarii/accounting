package com.accounting.shared.mapper;

import com.accounting.contract.dto.journal.JournalDto;
import com.accounting.domain.entitites.Journal;
import org.springframework.stereotype.Component;

@Component
public class JournalMapper extends BaseMapper {
    public JournalMapper() {
        super();
    }

    public Journal mapToJournal(JournalDto model) {
        return modelMapper.map(model, Journal.class);
    }

    public JournalDto mapToJournalDTO(Journal model) {
        return modelMapper.map(model, JournalDto.class);
    }

}
