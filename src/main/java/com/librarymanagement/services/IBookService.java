package com.librarymanagement.services;

import com.librarymanagement.entities.Book;
import com.librarymanagement.models.BookModel;
import com.librarymanagement.payloads.CreateBookRequest;

import java.util.List;

public interface IBookService {
    List<Book> getAllBooks();
    BookModel getBookById(String bookId);
    BookModel createBook(Book book);
    BookModel updateBook(Book book);
    void deleteBook(String bookId);
}
