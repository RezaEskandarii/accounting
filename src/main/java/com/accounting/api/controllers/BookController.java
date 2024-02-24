package com.accounting.api.controllers;

import com.accounting.commons.ApiResponse;
import com.accounting.config.APIConfig;
import com.accounting.contract.dto.book.CreateUpdateBookDto;
import com.accounting.contract.interfaces.BookAppService;
import com.accounting.shared.filters.PaginationInput;
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
        var result = new ApiResponse(bookAppService.find(id));
        return ResponseEntity.ok(result);
    }


    @PostMapping(path = "")
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody CreateUpdateBookDto dto, Locale locale) {
        var result = new ApiResponse(bookAppService.create(dto));
        return ResponseEntity.ok(result);
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id) {
        bookAppService.delete(id);
        return ResponseEntity.ok(new ApiResponse());
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> update(@Valid @RequestBody CreateUpdateBookDto dto, @PathVariable Long id, Locale locale) {
        var result = bookAppService.update(id, dto);
        return ResponseEntity.ok(new ApiResponse(result));
    }

    @GetMapping(path = "")
    public ResponseEntity<ApiResponse> findAll(PaginationInput paginationInput) {
        var result = bookAppService.findAll(paginationInput);
        return ResponseEntity.ok(new ApiResponse(result));
    }
}
