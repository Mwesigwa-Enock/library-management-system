package com.librarymanagement.services;

import com.librarymanagement.models.PatronModel;
import com.librarymanagement.payloads.CreatePatronRequest;

import java.util.List;

public interface IPatronService{
    List<PatronModel> getAllPatrons();
    PatronModel getPatronById(String patronId);
    PatronModel createPatron(CreatePatronRequest patronRequest);
    PatronModel updatePatron(PatronModel patronModel, String patronId) throws Exception;
    void deletePatron(String patronId);
}
