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
public class CreatePatronRequest implements Serializable {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;
}
