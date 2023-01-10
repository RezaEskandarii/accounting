package com.accounting.repositories.interfaces;

import com.accounting.domain.entitites.Account;
import com.accounting.domain.entitites.Journal;
import com.accounting.domain.entitites.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface JournalRepository extends JpaRepository<Journal, Long> {

}
