package com.accounting.domain.services;

import com.accounting.repositories.interfaces.JournalCrudRepository;
import com.accounting.shared.filters.PaginationInput;
import com.accounting.domain.entitites.Journal;
import com.accounting.domain.interfaces.JournalRepository;
import com.accounting.shared.exceptions.ItemNotFoundException;
import com.accounting.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

public class JournalRepositoryImpl implements JournalRepository {


    @Autowired
    private JournalCrudRepository journalRepository;

    @Override
    public Journal create(Journal journal) {

        for (var tnx : journal.getTransactions()) {
            tnx.setBook(journal.getBook());
        }

        return journalRepository.save(journal);
    }

    @Override
    public Journal update(Long id, Journal journal) {
        journal.id = id;
        for (var tnx : journal.getTransactions()) {
            tnx.setBook(journal.getBook());
        }
        return journalRepository.save(journal);
    }

    @Override
    public Journal find(Long id) {
        return journalRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    @Override
    public void delete(Long id) {
        journalRepository.deleteById(id);
    }

    @Override
    public Page<Journal> findAll(PaginationInput input) {
        return journalRepository.findAll(PageUtils.GetRequest(input));
    }
}