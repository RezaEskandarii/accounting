package com.accounting.jparepository;

import com.accounting.domain.entitites.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface BookCrudRepository extends JpaRepository<Book, Long> {
}
