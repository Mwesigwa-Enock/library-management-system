package com.librarymanagement.controllers;

import com.librarymanagement.models.BookModel;
import com.librarymanagement.payloads.CreateBookRequest;
import com.librarymanagement.payloads.GenericResponse;
import com.librarymanagement.services.BookService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create Book", description = "Returns book details")
    public ResponseEntity<GenericResponse> createBook(@RequestBody CreateBookRequest bookRequest) {
        return new ResponseEntity<>(GenericResponse.builder().build(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    @Operation(summary = "Get All Books", description = "Returns a List of books")
    public ResponseEntity<List<BookModel>> getBooks() {
        return new ResponseEntity<>(List.of(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Operation(summary = "Get Book by Id", description = "Returns book details")
    public ResponseEntity<BookModel> getBookById(@PathVariable String id) {
        return new ResponseEntity<>(BookModel.builder().build(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @Operation(summary = "Update Book by Id", description = "Returns book details")
    public ResponseEntity<GenericResponse> updateBookById(@PathVariable String id, @RequestBody BookModel bookModel) {
        return new ResponseEntity<>(GenericResponse.builder().build(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @Operation(summary = "Delete Book by Id", description = "Deletes book details")
    public ResponseEntity<GenericResponse> deleteBookById(@PathVariable String id) {
        return new ResponseEntity<>(GenericResponse.builder().build(), HttpStatus.OK);
    }
}
