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
public class PatronModel implements Serializable {
    private String patronId;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String city;
    private String status;
    private Timestamp createdOn;
    private Timestamp modifiedOn;
}
