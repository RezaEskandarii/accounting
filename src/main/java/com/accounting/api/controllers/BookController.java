package com.accounting.api.controllers;

import com.accounting.commons.ApiResponse;
import com.accounting.config.APIConfig;
import com.accounting.contract.dto.book.CreateUpdateBookDto;
import com.accounting.contract.interfaces.BookAppService;
import com.accounting.shared.filters.PaginationInput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Locale;

@RestController
@RequestMapping(path = APIConfig.BOOKS_CONTROLLER)
public class BookController extends BaseController {

    final BookAppService bookAppService;

    public BookController(BookAppService bookAppService) {
        this.bookAppService = bookAppService;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> find(@PathVariable Long id) {
        var resp = new ApiResponse()
                .setData(bookAppService.find(id));
        return ResponseEntity.ok(resp);
    }


    @PostMapping(path = "")
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody CreateUpdateBookDto dto, Locale locale) {
        var resp = new ApiResponse()
                .setData(bookAppService.create(dto))
                .setStatusCode(HttpStatus.OK);

        return ResponseEntity.ok(resp);
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id) {

        bookAppService.delete(id);
        var resp = new ApiResponse()
                .setStatusCode(HttpStatus.OK);

        return ResponseEntity.ok(resp);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> update(@Valid @RequestBody CreateUpdateBookDto dto, @PathVariable Long id, Locale locale) {
        var resp = new ApiResponse()
                .setData(bookAppService.update(id, dto))
                .setStatusCode(HttpStatus.OK);

        return ResponseEntity.ok(resp);
    }

    @GetMapping(path = "")
    public ResponseEntity<ApiResponse> findAll(PaginationInput paginationInput) {
        var resp = new ApiResponse()
                .setData(bookAppService.findAll(paginationInput))
                .setStatusCode(HttpStatus.OK);

        return ResponseEntity.ok(resp);
    }
}
