package com.accounting.shared.mapper;

import com.accounting.contract.dto.journal.JournalDto;
import com.accounting.domain.entitites.Journal;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JournalMapper extends BaseMapper {
    public JournalMapper() {
        super();
    }

    public Journal mapToJournal(Object model) {
        return modelMapper.map(model, Journal.class);
    }

    public JournalDto mapToJournalDTO(Object model) {
        return modelMapper.map(model, JournalDto.class);
    }

}
