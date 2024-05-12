package com.librarymanagement.services;

import com.librarymanagement.entities.Book;
import com.librarymanagement.models.BookModel;
import com.librarymanagement.payloads.CreateBookRequest;
import com.librarymanagement.payloads.GenericResponse;

import java.util.List;

public interface IBookService {
    List<BookModel> getAllBooks();
    BookModel getBookById(String bookId);
    BookModel createBook(CreateBookRequest bookRequest);
    BookModel updateBook(BookModel bookModel, String bookId);
    void deleteBook(String bookId);
}
