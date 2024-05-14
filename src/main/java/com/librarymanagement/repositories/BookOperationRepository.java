package com.librarymanagement.repositories;

import com.librarymanagement.entities.BookOperations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookOperationRepository extends JpaRepository<BookOperations, Long> {
    Optional<BookOperations> findByRecordId(String recordId);
    Optional<BookOperations> findByBook_BookIdAndPatron_PatronId(String bookId, String patronId);

}
