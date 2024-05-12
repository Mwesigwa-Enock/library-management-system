package com.librarymanagement.controllers;

import com.librarymanagement.entities.BookOperations;
import com.librarymanagement.services.BookOperationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class BookOperationsController {
private final BookOperationService bookOperationService;

}
