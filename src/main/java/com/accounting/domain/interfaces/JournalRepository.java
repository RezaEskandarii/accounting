package com.accounting.domain.interfaces;

import com.accounting.domain.entitites.Journal;
import com.accounting.shared.filters.PaginationInput;
import org.springframework.data.domain.Page;

public interface JournalRepository {
    Journal create(Journal journal);

    Journal update(Long id, Journal journal);

    Journal find(Long id);

    void delete(Long id);

    Page<Journal> findAll(PaginationInput input);
}
