package com.librarymanagement.services;

import com.librarymanagement.constants.BookActions;
import com.librarymanagement.entities.BookOperations;
import com.librarymanagement.exceptions.NotFoundException;
import com.librarymanagement.models.BookOperationModel;
import com.librarymanagement.payloads.BookOperationRequest;
import com.librarymanagement.repositories.BookOperationRepository;
import com.librarymanagement.repositories.BookRepository;
import com.librarymanagement.repositories.PatronRepository;
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
public class BookOperationService implements IBookOperationService {
    private static final Logger logger = LoggerFactory.getLogger(BookOperationService.class);
    private final BookOperationRepository bookOperationRepository;
    private final BookRepository bookRepository;
    private final PatronRepository patronRepository;

    @Override
    public List<BookOperationModel> getAllRecords() {
        logger.info("Get all Records");
        var records = bookOperationRepository.findAll();
        ModelMapper modelMapper = new ModelMapper();
        return records.stream().
                map(record -> modelMapper.map(record, BookOperationModel.class))
                .toList();
    }

    @Override
    public BookOperationModel getRecordById(String recordId) {
        logger.info("Get Book Operation by Id");
        var record = bookOperationRepository.findByRecordId(recordId);
        if (record.isPresent()) {
            logger.info("Book Record with id {} found", recordId);
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(record.get(), BookOperationModel.class);
        } else {
            logger.error("Book Record with id {} Not found", recordId);
            throw new NotFoundException("Book Record with id " + recordId + " Not found");
        }

    }

    @Transactional
    @Override
    public BookOperationModel createRecord(String bookId, String patronId, BookActions action) {
        logger.info("Create Book Operation");
        var book = bookRepository.findBybookId(bookId);
        var patron = patronRepository.findByPatronId(patronId);
        if (book.isPresent() && patron.isPresent()) {
            var createdBy = StringHelper.concatenateStrings(patron.get().getFirstname(), patron.get().getLastname());
            var record = BookOperations.builder()
                    .book(book.get())
                    .action(action)
                    .patron(patron.get())
                    .recordId(StringHelper.generateUuid())
                    .createdBy(createdBy)
                    .build();
            var created = bookOperationRepository.save(record);
            logger.info("Book Operation with id {} created", created.getRecordId());

            var available = action.name().equals("BORROW");
            book.get().setAvailable(available);
            bookRepository.save(book.get());
            logger.info("Book with id {} updated", book.get().getBookId());

            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(created, BookOperationModel.class);
        } else {
            logger.error("Book Record with id {} and Patron with id {} Not found",
                    book, patronId);
            throw new NotFoundException("Invalid Book Operation");
        }

    }

    @Override
    public BookOperationModel updateRecord(BookOperations bookOperations) {
        return null;
    }
}
