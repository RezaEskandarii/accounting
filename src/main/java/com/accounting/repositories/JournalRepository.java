package com.accounting.repositories;

import com.accounting.entitites.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface JournalRepository extends JpaRepository<Journal, Long> {
}
