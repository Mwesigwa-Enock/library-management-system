package com.librarymanagement.services;

import com.librarymanagement.models.BookModel;
import com.librarymanagement.payloads.CreateBookRequest;

import java.util.List;

public interface IBookService {
    List<BookModel> getAllBooks();
    BookModel getBookById(String bookId);
    BookModel createBook(CreateBookRequest bookRequest) throws Exception;
    BookModel updateBook(BookModel bookModel, String bookId);
    void deleteBook(String bookId);
}
