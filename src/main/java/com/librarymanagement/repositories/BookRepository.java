package com.librarymanagement.repositories;

import com.librarymanagement.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findBybookId(String bookId);
    Optional<Book> findByBookIdAndAvailable(String bookId, boolean available);
}
