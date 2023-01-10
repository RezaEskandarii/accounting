package com.accounting.repositories.interfaces;

import com.accounting.domain.entitites.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class ReportRepository {

    @Autowired
    EntityManager em;

    // constructor

    public List<Book> findBooksByAuthorNameAndTitle(String authorName, String title) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);

        Root<Book> book = cq.from(Book.class);
        Predicate authorNamePredicate = cb.equal(book.get("name"), authorName);
        Predicate titlePredicate = cb.like(book.get("name"), "%" + title + "%");
        cq.where(authorNamePredicate, titlePredicate);


        TypedQuery<Book> query = em.createQuery(cq);
        return query.getResultList();
    }

}
