package com.librarymanagement.services;

import com.librarymanagement.constants.BookStatus;
import com.librarymanagement.entities.Book;
import com.librarymanagement.exceptions.NotFoundException;
import com.librarymanagement.models.BookModel;
import com.librarymanagement.payloads.CreateBookRequest;
import com.librarymanagement.repositories.BookRepository;
import com.librarymanagement.utils.StringHelper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService implements IBookService {
    private static final Logger logger = LoggerFactory.getLogger(BookService.class);
    private final BookRepository bookRepository;

    @Override
    public List<BookModel> getAllBooks() {
        logger.info("Get all books request");
        var books = bookRepository.findAll();
        ModelMapper mapper = new ModelMapper();
        return books.stream().map(
                        book -> mapper.map(book, BookModel.class))
                .toList();
    }

    @Override
    public BookModel getBookById(String bookId) {
        logger.info("Get book by id request");
        var book = bookRepository.findBybookId(bookId);
        if (book.isPresent()) {
            logger.info("Book with id {} found", bookId);
            ModelMapper mapper = new ModelMapper();
            return mapper.map(book.get(), BookModel.class);
        }else {
            logger.error("Book with id {} not found", bookId);
            throw new NotFoundException("Book with id " + bookId + " not found");
        }
    }

    @Transactional
    @Override
    public BookModel createBook(CreateBookRequest bookRequest) throws Exception {
        try {
        logger.info("Create book request");
        var bookId = StringHelper.generateUuid();
        var book = Book.builder()
                .bookId(bookId)
                .title(bookRequest.getTitle())
                .author(bookRequest.getAuthor())
                .publisher(bookRequest.getPublisher())
                .publicationYear(bookRequest.getPublicationYear())
                .isbn(bookRequest.getIsbn())
                .status(BookStatus.ACTIVE)
                .createdBy("SYSTEM") //TODO get user performing the action from claims
                .available(true)
                .isDeleted(false)
                .build();
        var savedBook = bookRepository.save(book);
        logger.info("The book with id {} is created successfully", bookId);
        return new ModelMapper().map(savedBook, BookModel.class);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new Exception("Failed to create book", e);
        }
    }

    @Override
    public BookModel updateBook(BookModel bookRequest, String bookId) {
        logger.info("Update book request");
        var book = bookRepository.findBybookId(bookId);
        if (book.isPresent()) {
            ModelMapper mapper = new ModelMapper();
            var foundBook = book.get();
            foundBook.setIsbn(bookRequest.getIsbn());
            foundBook.setTitle(bookRequest.getTitle());
            foundBook.setAuthor(bookRequest.getAuthor());
            foundBook.setPublisher(bookRequest.getPublisher());
            foundBook.setPublicationYear(bookRequest.getPublicationYear());
            foundBook.setModifiedBy("SYSTEM");
            foundBook.setStatus(BookStatus.valueOf(bookRequest.getStatus()));
            var updated = bookRepository.save(foundBook);
            var response = mapper.map(updated, BookModel.class);
            logger.info("The book with id {} is updated successfully", bookId);
            return response;
        }
        throw new NotFoundException("Book with id " + bookId + " not found");
    }

    @Override
    public void deleteBook(String bookId) {
        logger.info("Delete book by id request");
        var book = bookRepository.findBybookId(bookId);
        if (book.isPresent()) {
            bookRepository.delete(book.get());
            logger.info("The book with id {} is deleted successfully", bookId);
        }else {
            logger.error("Delete operation cannot be performed, Book with id {} not found", bookId);
            throw new NotFoundException("Book with id " + bookId + " not found");
        }
    }
}
