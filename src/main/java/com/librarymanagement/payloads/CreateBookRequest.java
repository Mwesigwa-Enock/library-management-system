package com.librarymanagement.payloads;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateBookRequest implements Serializable {
    private String title;
    private String author;
    private String isbn;
    private String publisher;
    private String publicationYear;
}
