package com.accounting.api.controllers;

import com.accounting.commons.ApiResponse;
import com.accounting.config.APIConfig;
import com.accounting.contract.dto.PaginationInput;
import com.accounting.contract.dto.book.CreateUpdateBookDto;
import com.accounting.contract.interfaces.BookAppService;
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


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> create(@PathVariable Long id) {

        bookAppService.delete(id);
        var resp = new ApiResponse()
                .setStatusCode(HttpStatus.OK);

        return new ResponseEntity<>(resp, resp.statusCode);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> update(@Valid @RequestBody CreateUpdateBookDto dto, @PathVariable Long id, Locale locale) {
        var resp = new ApiResponse()
                .setData(bookAppService.update(id, dto))
                .setStatusCode(HttpStatus.OK);

        return new ResponseEntity<>(resp, resp.statusCode);
    }

    @GetMapping(path = "")
    public ResponseEntity<ApiResponse> findAll(PaginationInput paginationInput) {
        var resp = new ApiResponse()
                .setData(bookAppService.findAll(paginationInput))
                .setStatusCode(HttpStatus.OK);

        return new ResponseEntity<>(resp, resp.statusCode);
    }
}
