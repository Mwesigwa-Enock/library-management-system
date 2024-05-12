package com.librarymanagement.controllers;

import com.librarymanagement.models.PatronModel;
import com.librarymanagement.payloads.CreatePatronRequest;
import com.librarymanagement.payloads.GenericResponse;
import com.librarymanagement.services.PatronService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/patrons")
public class PatronController {
    private final PatronService patronService;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create Patron", description = "Returns patron details")
    public ResponseEntity<PatronModel> createPatron(@RequestBody CreatePatronRequest patronRequest) {
        return new ResponseEntity<>(PatronModel.builder().build(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    @Operation(summary = "Get All Patron", description = "Returns a List of Patron")
    public ResponseEntity<List<PatronModel>> getPatrons() {
        return new ResponseEntity<>(List.of(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Operation(summary = "Get Patron by Id", description = "Returns patron details")
    public ResponseEntity<PatronModel> getPatronById(@PathVariable String id) {
        return new ResponseEntity<>(PatronModel.builder().build(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @Operation(summary = "Update Patron by Id", description = "Returns patron details")
    public ResponseEntity<GenericResponse> updatePatronById(@PathVariable String id, @RequestBody PatronModel patronModel) {
        return new ResponseEntity<>(GenericResponse.builder().build(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @Operation(summary = "Delete Patron by Id", description = "Deletes Patron details")
    public ResponseEntity<GenericResponse> deletePatronById(@PathVariable String id) {
        return new ResponseEntity<>(GenericResponse.builder().build(), HttpStatus.OK);
    }
}
