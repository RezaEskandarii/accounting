package com.accounting.repositories.interfaces;

import com.accounting.domain.entitites.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface JournalRepository extends JpaRepository<Journal, Long> {
}
