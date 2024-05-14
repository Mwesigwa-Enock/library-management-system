package com.librarymanagement.models;

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
public class BookModel implements Serializable {
    private String bookId;
    private String title;
    private String author;
    private String publicationYear;
    private String isbn;
    private String publisher;
    private String status;
    private boolean available;
    private Timestamp createdOn;
    private Timestamp modifiedOn;
}
