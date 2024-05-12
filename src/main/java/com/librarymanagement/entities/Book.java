package com.librarymanagement.entities;

import com.librarymanagement.constants.BookStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name ="book_id", nullable = false, updatable = false)
    private String bookId;
    private String title;
    private String author;
    @Column(name = "publication_year")
    private String publicationYear;

    @Column(nullable = false, unique = true)
    private String isbn;
    private String publisher;

    @Enumerated(EnumType.STRING)
    private BookStatus status;

    private String createdBy;
    private String modifiedBy;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @CreationTimestamp
    @Column(name = "created_on")
    private Timestamp createdOn;

    @UpdateTimestamp
    @Column(name = "modified_on")
    private Timestamp modifiedOn;
}
