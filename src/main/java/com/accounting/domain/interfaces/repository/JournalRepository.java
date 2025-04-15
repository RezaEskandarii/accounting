package com.accounting.domain.interfaces.repository;

import com.accounting.domain.entitites.Journal;
import com.accounting.shared.filters.PaginationInput;
import org.springframework.data.domain.Page;

import java.util.List;

public interface JournalRepository {
    Journal create(Journal journal);

    Journal update(Long id, Journal journal);

    Journal find(Long id);

    void delete(Long id);
    List<Journal> findByBookId(Long bookId);
    Page<Journal> findAll(PaginationInput input);
}
