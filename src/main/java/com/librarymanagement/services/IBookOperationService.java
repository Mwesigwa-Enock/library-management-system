package com.librarymanagement.services;

import com.librarymanagement.models.BookOperationModel;

import java.util.List;

public interface IBookOperationService {
    List<BookOperationModel> getAllRecords();
    BookOperationModel getRecordById(String recordId);
    BookOperationModel borrowBook(String bookId, String patronId) throws Exception;
    BookOperationModel returnBook(String bookId, String patronId) throws Exception;
}
