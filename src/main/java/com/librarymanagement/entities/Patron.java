package com.librarymanagement.entities;

import com.librarymanagement.constants.PatronStatus;
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
@Table(name = "patrons")
public class Patron {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patron_id", nullable = false, unique = true)
    private String patronId;
    private String firstname;
    private String lastname;

    @Column(unique = true, nullable = false)
    private String phoneNumber;

    @Column(unique = true, nullable = false)
    private String email;
    private String address;

    @Enumerated(EnumType.STRING)
    private PatronStatus status;

    private String createdBy;
    private String modifiedBy;

    @CreationTimestamp
    @Column(name = "created_on")
    private Timestamp createdOn;

    @UpdateTimestamp
    @Column(name = "modified_on")
    private Timestamp modifiedOn;

}
