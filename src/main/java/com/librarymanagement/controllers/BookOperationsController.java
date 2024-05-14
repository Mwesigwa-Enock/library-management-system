package com.librarymanagement.controllers;

import com.librarymanagement.constants.BookActions;
import com.librarymanagement.models.BookOperationModel;
import com.librarymanagement.services.BookOperationService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class BookOperationsController {
    private final BookOperationService bookOperationService;

    @RequestMapping(value = "/borrow/{bookId}/patron/{patronId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Borrow Books", description = "Returns record details")
    public ResponseEntity<BookOperationModel> borrowBook(@PathVariable String bookId, @PathVariable String patronId) throws Exception {
        var response = bookOperationService.borrowBook(bookId, patronId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/return/{bookId}/patron/{patronId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Return Books", description = "Returns record details")
    public ResponseEntity<BookOperationModel> returnBook(@PathVariable String bookId, @PathVariable String patronId) throws Exception {
        var response = bookOperationService.returnBook(bookId, patronId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/records", method = RequestMethod.GET)
    @Operation(summary = "Return All Borrowing Records", description = "Returns records details")
    public ResponseEntity<List<BookOperationModel>> getAllRecords() {
        var response = bookOperationService.getAllRecords();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/records/{id}", method = RequestMethod.GET)
    @Operation(summary = "Return Borrowing Record By Id", description = "Returns record details")
    public ResponseEntity<BookOperationModel> getRecordById(@PathVariable String id) {
        var response = bookOperationService.getRecordById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
