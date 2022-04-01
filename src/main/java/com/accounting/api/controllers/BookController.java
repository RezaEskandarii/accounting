package com.accounting.api.controllers;

import com.accounting.commons.ApiResponse;
import com.accounting.config.APIConfig;
import com.accounting.contract.dto.book.CreateUpdateBookDto;
import com.accounting.contract.interfaces.BookAppService;
import com.accounting.domain.entitites.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Locale;

@RestController
@RequestMapping(path = APIConfig.BOOKS_CONTROLLER)
public class BookController extends BaseController {

    @Autowired
    BookAppService bookAppService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> find(@PathVariable Long id) {
        var resp = new ApiResponse()
                .setData(bookAppService.find(id))
                .setStatusCode(HttpStatus.OK);

        return new ResponseEntity<>(resp, resp.statusCode);
    }


    @PostMapping(path = "")
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody CreateUpdateBookDto dto, Locale locale) {
        var resp = new ApiResponse()
                .setData(bookAppService.create(dto))
                .setStatusCode(HttpStatus.OK);

        return new ResponseEntity<>(resp, resp.statusCode);
    }
}
