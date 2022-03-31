package com.accounting.repositories;

import com.accounting.entitites.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface BookRepository extends JpaRepository<Book, Long> {
}
