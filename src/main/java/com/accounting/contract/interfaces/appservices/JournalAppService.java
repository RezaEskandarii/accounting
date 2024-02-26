package com.accounting.contract.interfaces.appservices;

import com.accounting.contract.dto.journal.JournalDto;
import com.accounting.shared.filters.PaginationInput;
import org.springframework.data.domain.Page;

public interface JournalAppService {
    JournalDto create(JournalDto dto);

    JournalDto update(Long id, JournalDto dto);

    JournalDto find(Long id);

    void delete(Long id);

    Page<JournalDto> findAll(PaginationInput input);
}
