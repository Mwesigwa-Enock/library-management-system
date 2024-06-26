package com.librarymanagement.models;

import com.librarymanagement.utils.StringHelper;
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
public class PatronModel implements Serializable {
    private String patronId;
    private String name;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String email;
    private String address;
    private String status;
    private Timestamp createdOn;
    private Timestamp modifiedOn;
}
