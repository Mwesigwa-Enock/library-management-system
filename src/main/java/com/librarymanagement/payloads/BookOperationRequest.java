package com.librarymanagement.payloads;

import com.librarymanagement.constants.BookActions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookOperationRequest {
    private String bookId;
    private BookActions action;
    private String patronId;
    private boolean isAvailable;
    private Date requestDate;
    private Date returnDate;
}
