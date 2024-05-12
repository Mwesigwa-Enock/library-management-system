package com.librarymanagement.services;

import com.librarymanagement.entities.BookOperations;
import com.librarymanagement.models.BookOperationModel;

import java.util.List;

public interface IBookOperationService {
    List<BookOperations> getAllRecords();
    BookOperationModel getRecordById(String recordId);
    BookOperationModel createRecord(BookOperations bookOperations);
    BookOperationModel updateRecord(BookOperations bookOperations);
}
