package com.librarymanagement.services;

import com.librarymanagement.constants.BookActions;
import com.librarymanagement.entities.BookOperations;
import com.librarymanagement.models.BookOperationModel;

import java.util.List;

public interface IBookOperationService {
    List<BookOperationModel> getAllRecords();
    BookOperationModel getRecordById(String recordId);
    BookOperationModel createRecord(String bookId, String patronId, BookActions action);
    BookOperationModel updateRecord(BookOperations bookOperations);
}
