package com.accounting.contract.interfaces;

import com.accounting.contract.dto.PaginationInput;
import com.accounting.contract.dto.journal.JournalDto;
import org.springframework.data.domain.Page;

public interface JournalAppService {
    public JournalDto create(JournalDto dto);

    public JournalDto update(Long id, JournalDto dto);

    public JournalDto find(Long id);

    public void delete(Long id);

    public Page<JournalDto> findAll(PaginationInput input);
}
