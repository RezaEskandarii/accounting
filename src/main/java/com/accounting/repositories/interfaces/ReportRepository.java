package com.accounting.repositories.interfaces;

import com.accounting.domain.entitites.Book;
import com.accounting.domain.entitites.Transaction;
import com.sun.istack.Nullable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

public class ReportRepository     {

    EntityManager em;

    // constructor

    List<Book> findBooksByAuthorNameAndTitle(String authorName, String title) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);

        Root<Book> book = cq.from(Book.class);
        Predicate authorNamePredicate = cb.equal(book.get("author"), authorName);
        Predicate titlePredicate = cb.like(book.get("title"), "%" + title + "%");
        cq.where(authorNamePredicate, titlePredicate);
         book.join("Transaction");

        TypedQuery<Book> query = em.createQuery(cq);
        return query.getResultList();
    }

}
