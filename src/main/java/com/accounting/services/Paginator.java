package com.accounting.services;

import com.accounting.dto.PaginationInput;
import com.accounting.entitites.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class Paginator<T extends BaseEntity> {


}
