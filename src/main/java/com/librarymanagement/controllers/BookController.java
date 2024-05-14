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
    public ResponseEntity<BookModel> createBook(@RequestBody CreateBookRequest bookRequest) throws Exception {
        var book = bookService.createBook(bookRequest);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    @Operation(summary = "Get All Books", description = "Returns a List of books")
    public ResponseEntity<List<BookModel>> getBooks() {
        var books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Operation(summary = "Get Book by Id", description = "Returns book details")
    public ResponseEntity<BookModel> getBookById(@PathVariable String id) {
        var book = bookService.getBookById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @Operation(summary = "Update Book by Id", description = "Returns book details")
    public ResponseEntity<BookModel> updateBookById(@PathVariable String id, @RequestBody BookModel bookModel) {
        var updated = bookService.updateBook(bookModel, id);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @Operation(summary = "Delete Book by Id", description = "Deletes book details")
    public ResponseEntity<GenericResponse> deleteBookById(@PathVariable String id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(GenericResponse.builder()
                .code(HttpStatus.OK.toString())
                .message("Book deleted successfully")
                .build(), HttpStatus.OK);
    }
}
