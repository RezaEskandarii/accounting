package com.accounting.api.controllers;

import com.accounting.config.APIConfig;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = APIConfig.BOOKS_CONTROLLER)
public class BookController {

}
