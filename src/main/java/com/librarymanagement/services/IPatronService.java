package com.librarymanagement.services;

import com.librarymanagement.entities.Patron;
import com.librarymanagement.models.PatronModel;

import java.util.List;

public interface IPatronService{
    List<Patron> getAllPatrons();
    PatronModel getPatronById(String patronId);
    PatronModel createPatron(Patron patron);
    PatronModel updatePatron(Patron patron);
    void deletePatron(String patronId);
}
