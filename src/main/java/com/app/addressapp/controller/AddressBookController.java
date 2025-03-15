package com.app.addressapp.controller;

import com.app.addressapp.dto.AddressBookDTO;
import com.app.addressapp.model.AddressBookModel;
import com.app.addressapp.service.AddressBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class AddressBookController {

    @Autowired
    private AddressBookService service;

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        log.info("Accessed /hello endpoint");
        return ResponseEntity.ok("Welcome to the Address Book App!");
    }

    @GetMapping("/all")
    public ResponseEntity<List<AddressBookModel>> getAllContacts() {
        log.info("Fetching all contacts");
        return ResponseEntity.ok(service.getAllContacts());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getContact(@PathVariable Long id) {
        log.info("Fetching contact with ID: {}", id);
        AddressBookModel contact = service.getContactById(id);
        return contact != null ? ResponseEntity.ok(contact) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Contact with ID " + id + " not found")); // ✅ UC 12: Return 404 if not found
    }

    @PostMapping("/create")
    public ResponseEntity<AddressBookModel> createContact(@Valid @RequestBody AddressBookDTO dto) {
        log.info("Creating new contact: {}", dto.getFullName());
        return ResponseEntity.ok(service.createContact(dto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateContact(@PathVariable Long id, @Valid @RequestBody AddressBookDTO dto) {
        log.info("Updating contact with ID: {}", id);
        AddressBookModel result = service.updateContact(id, dto);
        return result != null ? ResponseEntity.ok(result) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Contact with ID " + id + " not found")); // ✅ UC 12: Return 404 if not found
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        log.info("Deleting contact with ID: {}", id);
        if (service.getContactById(id) == null) {
            log.warn("Contact with ID {} not found for deletion", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Contact with ID " + id + " not found for deletion"); // ✅ UC 12: Return 404 if not found
        }
        service.deleteContact(id);
        return ResponseEntity.ok("Successfully deleted contact with ID: " + id);
    }
}