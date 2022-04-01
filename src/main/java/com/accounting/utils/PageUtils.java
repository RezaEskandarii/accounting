package com.accounting.utils;

import com.accounting.contract.dto.PaginationInput;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class PageUtils {

    public static PageRequest GetRequest(PaginationInput paginationInput) {

        if (paginationInput.getPageNumber() <= 0)
            paginationInput.setPageNumber(0);

        if (paginationInput.getPageSize() <= 0)
            paginationInput.setPageSize(20);

        var pageable = PageRequest.of(paginationInput.getPageNumber(), paginationInput.getPageSize());
        var sort = Sort.Direction.DESC;

        if (paginationInput.getSortType() != null && paginationInput.getSortType().equals("ASC"))
            sort = Sort.Direction.ASC;

        if (paginationInput.getSortableField() != null) {
            pageable = pageable.withSort(sort, paginationInput.getSortableField());
        } else {
            pageable = pageable.withSort(sort, "id");
        }

        return pageable;
    }
}
