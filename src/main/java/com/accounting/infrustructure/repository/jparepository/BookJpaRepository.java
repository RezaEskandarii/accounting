package com.accounting.infrustructure.repository.jparepository;

import com.accounting.domain.entitites.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BookJpaRepository extends JpaRepository<Book, Long> {
}
