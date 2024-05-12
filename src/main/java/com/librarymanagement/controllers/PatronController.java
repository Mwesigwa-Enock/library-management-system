package com.librarymanagement.controllers;

import com.librarymanagement.services.PatronService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/patrons")
public class PatronController {
    private final PatronService patronService;
}
