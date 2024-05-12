package com.librarymanagement.services;

import com.librarymanagement.entities.Book;
import com.librarymanagement.models.BookModel;
import com.librarymanagement.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService implements IBookService {
    private static final Logger logger = LoggerFactory.getLogger(BookService.class);
    private final BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return List.of();
    }

    @Override
    public BookModel getBookById(String bookId) {
        return null;
    }

    @Override
    public BookModel createBook(Book book) {
        return null;
    }

    @Override
    public BookModel updateBook(Book book) {
        return null;
    }

    @Override
    public void deleteBook(String bookId) {

    }
}
