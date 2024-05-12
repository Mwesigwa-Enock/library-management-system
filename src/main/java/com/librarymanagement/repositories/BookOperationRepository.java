package com.librarymanagement.repositories;

import com.librarymanagement.entities.BookOperations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookOperationRepository extends JpaRepository<BookOperations, Long> {
}
