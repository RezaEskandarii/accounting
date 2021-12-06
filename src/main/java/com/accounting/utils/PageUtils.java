package com.accounting.utils;

import com.accounting.dto.PaginationInput;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class PageUtils {

    public static PageRequest GetRequest(PaginationInput paginationInput) {

        var pageable = PageRequest.of(paginationInput.getPageNumber(), paginationInput.getPageSize());
        var sort = Sort.Direction.ASC;

        if (paginationInput.getSortType() != null && paginationInput.getSortType().equals("DESC"))
            sort = Sort.Direction.DESC;

        if (paginationInput.getSortableField() != null) {
            pageable = pageable.withSort(sort, paginationInput.getSortableField());
        } else {
            pageable = pageable.withSort(sort);
        }

        return pageable;
    }
}
