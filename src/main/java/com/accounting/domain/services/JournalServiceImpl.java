package com.accounting.domain.services;

import com.accounting.contract.dto.PaginationInput;
import com.accounting.domain.entitites.Journal;
import com.accounting.domain.interfaces.JournalService;
import com.accounting.repositories.interfaces.JournalRepository;
import com.accounting.shared.exceptions.ItemNotFoundException;
import com.accounting.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

public class JournalServiceImpl implements JournalService {


    @Autowired
    private JournalRepository journalRepository;

    @Override
    public Journal create(Journal journal) {
        return journalRepository.save(journal);
    }

    @Override
    public Journal update(Long id, Journal journal) {
        journal.id = id;
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
