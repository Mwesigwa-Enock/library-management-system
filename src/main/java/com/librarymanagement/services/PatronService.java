package com.librarymanagement.services;

import com.librarymanagement.constants.PatronStatus;
import com.librarymanagement.entities.Patron;
import com.librarymanagement.exceptions.NotFoundException;
import com.librarymanagement.models.PatronModel;
import com.librarymanagement.payloads.CreatePatronRequest;
import com.librarymanagement.repositories.PatronRepository;
import com.librarymanagement.utils.StringHelper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
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
    public List<PatronModel> getAllPatrons() {
        logger.info("Get all patrons request");
        var patrons = patronRepository.findAll();
        ModelMapper modelMapper = new ModelMapper();
        return patrons.stream()
                .map(patron -> modelMapper.map(patron, PatronModel.class))
                .toList();
    }

    @Override
    public PatronModel getPatronById(String patronId) {
        logger.info("Get patron by id request");
        var patron = patronRepository.findByPatronId(patronId);
        if (patron.isPresent()) {
            logger.info("Patron with id {} found", patronId);
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(patron, PatronModel.class);
        } else {
            logger.error("Patron with id {} not found", patronId);
            throw new NotFoundException("Patron with id " + patronId + " not found");
        }
    }

    @Override
    public PatronModel createPatron(CreatePatronRequest patronRequest) {
        logger.info("Create patron request");
        var fullName = StringHelper.concatenateStrings(patronRequest.getLastName(), patronRequest.getFirstName());
        var patron = Patron.builder()
                .email(patronRequest.getEmail())
                .name(fullName)
                .firstname(patronRequest.getFirstName())
                .lastname(patronRequest.getLastName())
                .phoneNumber(patronRequest.getPhoneNumber())
                .address(patronRequest.getAddress())
                .patronId(StringHelper.generateUuid())
                .createdBy("SYSTEM") //TODO get user performing the action from claims
                .status(PatronStatus.ACTIVE)
                .build();
        var created = patronRepository.save(patron);
        logger.info("Patron with id {} created", created.getPatronId());
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(created, PatronModel.class);
    }

    @Override
    public PatronModel updatePatron(PatronModel patronRequest, String patronId) throws Exception {
        try {
            logger.info("Update patron by id request");
            var patron = patronRepository.findByPatronId(patronId);
            if (patron.isPresent()) {
                logger.info("Patron with - {} found", patronId);
                var name = StringHelper.concatenateStrings(patronRequest.getFirstname(), patronRequest.getLastname());
                var foundPatron = patron.get();
                foundPatron.setEmail(patronRequest.getEmail());
                foundPatron.setFirstname(patronRequest.getFirstname());
                foundPatron.setLastname(patronRequest.getLastname());
                foundPatron.setAddress(patronRequest.getAddress());
                foundPatron.setName(name);
                foundPatron.setPhoneNumber(patronRequest.getPhoneNumber());
                var updated = patronRepository.save(foundPatron);
                logger.info("Patron with id {} updated", patronId);
                ModelMapper modelMapper = new ModelMapper();
                return modelMapper.map(updated, PatronModel.class);
            } else {
                logger.error("Patron with - {} not found", patronId);
                throw new NotFoundException("Patron with id " + patronId + " not found");
            }
        }catch (Exception e) {
            logger.error(e.getMessage());
            throw new Exception("Failed to create book", e);
        }
    }

    @Override
    public void deletePatron(String patronId) {
        logger.info("Delete patron by id request");
        var patron = patronRepository.findByPatronId(patronId);
        if (patron.isPresent()) {
            patronRepository.delete(patron.get());
            logger.info("Patron with id {} deleted", patronId);
        } else {
            logger.error("Delete operation cannot be performed, Patron with id {} not found", patronId);
            throw new NotFoundException("Patron with id " + patronId + " not found");
        }
    }
}
