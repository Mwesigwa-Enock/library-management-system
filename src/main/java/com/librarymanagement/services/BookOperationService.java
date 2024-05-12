package com.librarymanagement.services;

import com.librarymanagement.entities.BookOperations;
import com.librarymanagement.models.BookOperationModel;
import com.librarymanagement.repositories.BookOperationRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class BookOperationService implements IBookOperationService {
    private static final Logger logger = LoggerFactory.getLogger(BookOperationService.class);
    private final BookOperationRepository bookOperationRepository;

    @Override
    public List<BookOperations> getAllRecords() {
        return List.of();
    }

    @Override
    public BookOperationModel getRecordById(String recordId) {
        return null;
    }

    @Transactional
    @Override
    public BookOperationModel createRecord(BookOperations bookOperations) {
        return null;
    }

    @Override
    public BookOperationModel updateRecord(BookOperations bookOperations) {
        return null;
    }
}
