package com.librarymanagement.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BookOperationModel implements Serializable {
    private String recordId;
    private PatronModel patron;
    private BookModel book;
    private String action;
    private Date borrowedOn;
    private Date returnedOn;
    private Timestamp createdOn;
    private Timestamp modifiedOn;
}
