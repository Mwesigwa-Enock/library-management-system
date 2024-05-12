package com.librarymanagement.services;

import com.librarymanagement.entities.Patron;
import com.librarymanagement.models.PatronModel;
import com.librarymanagement.repositories.PatronRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PatronService implements IPatronService {
    private static final Logger logger = LoggerFactory.getLogger(PatronService.class);
    private final PatronRepository patronRepository;

    @Override
    public List<Patron> getAllPatrons() {
        return List.of();
    }

    @Override
    public PatronModel getPatronById(String patronId) {
        return null;
    }

    @Override
    public PatronModel createPatron(Patron patron) {
        return null;
    }

    @Override
    public PatronModel updatePatron(Patron patron) {
        return null;
    }

    @Override
    public void deletePatron(String patronId) {

    }
}
