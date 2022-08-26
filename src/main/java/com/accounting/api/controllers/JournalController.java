package com.accounting.api.controllers;

import com.accounting.config.APIConfig;
import com.accounting.repositories.interfaces.JournalRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = APIConfig.JOURNALS_CONTROLLER)
public class JournalController extends BaseController {



}
