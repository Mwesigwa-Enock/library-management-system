package com.librarymanagement.models;

import com.librarymanagement.constants.BookActions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BookOperationModel implements Serializable {
    private String recordId;
    private PatronModel patron;
    private BookModel book;
    private BookActions action;
    private Timestamp createdOn;
    private Timestamp modifiedOn;
}
