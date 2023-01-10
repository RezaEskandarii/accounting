package com.accounting.domain.interfaces;

import com.accounting.shared.filters.PaginationInput;
import com.accounting.domain.entitites.Journal;
import org.springframework.data.domain.Page;

public interface JournalService {
    public Journal create(Journal journal);

    public Journal update(Long id, Journal journal);

    public Journal find(Long id);

    public void delete(Long id);

    public Page<Journal> findAll(PaginationInput input);
}
