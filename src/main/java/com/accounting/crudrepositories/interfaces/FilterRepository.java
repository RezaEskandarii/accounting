package com.accounting.crudrepositories.interfaces;

import com.accounting.domain.entitites.Account;
import com.accounting.shared.filters.TrialBalanceFilter;
import org.hibernate.Criteria;
import org.hibernate.internal.CriteriaImpl;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class FilterRepository {

    public void  f(TrialBalanceFilter filter){


    }
}
