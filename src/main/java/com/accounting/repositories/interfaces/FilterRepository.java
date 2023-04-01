package com.accounting.repositories.interfaces;

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
    /***
     * 	db := service.DB
     * 	result := make([]dtos.TrialBalanceDTO, 0)
     * 	//bookIdStr := strconv.Itoa(int(bookId))
     * 	accounts := make([]models.Account, 0)
     * 	jointField := "general_account_id"
     * 	if level == 2 {
     * 		jointField = "default_account_id"
     *        }
     * 	joinStr := fmt.Sprintf(" LEFT JOIN transactions on transactions.%s = accounts.id", jointField)
     *
     * 	selectStr := fmt.Sprintf(`accounts.id, accounts.code, accounts.name, accounts.type,
     * 				COALESCE(SUM(CASE WHEN transactions.book_id = %d  THEN transactions.debit ELSE 0 END )) as sum_debit,
     * 				COALESCE(SUM(CASE WHEN transactions.book_id = %d  THEN transactions.credit ELSE 0 END )) as sum_credit,
     * 				COALESCE(SUM(CASE WHEN transactions.book_id = %d  THEN transactions.credit -transactions.debit ELSE 0 END )) as balance `, bookId, bookId, bookId)
     *
     * 	var query = db.Table("accounts").Where("accounts.level = ?", level)
     * 	query = query.Select(selectStr).Joins(joinStr)
     * 	if from != "" {
     * 		query = query.Where("transactions.created_at >= ?", from)
     *    }
     * 	if to != "" {
     * 		query = query.Where("transactions.created_at <= ?", to)
     *    }
     * 	query = query.Where(" transactions.deleted_at IS NULL ")
     * 	query = query.Group("accounts.id")
     * 	query.Scan(&result)
     * 	db.Table("accounts").Preload("Parent").Preload("Category").Find(&accounts, "level = ?", level)
     * 	for index, item := range result {
     * 		for _, account := range accounts {
     * 			if item.Id == uint(account.ID) {
     * 				result[index].Account = &account
     * 				break
     *            }
     *        }
     *    }
     * 	return result, nil
     */



    public void  f(TrialBalanceFilter filter){


    }
}
