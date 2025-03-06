package com.app.addressapp.controller;

import com.app.addressapp.dto.AddressBookDTO;
import com.app.addressapp.model.AddressBookModel;
import com.app.addressapp.service.AddressBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressBookController {

    @Autowired
    private AddressBookService service;

    @GetMapping("/")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Welcome to the Address Book App!");
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<AddressBookModel>> getAllContacts() {
        return ResponseEntity.ok(service.getAllContacts());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getContact(@PathVariable Long id) {
        AddressBookModel contact = service.getContactById(id);
        return contact != null ? ResponseEntity.ok(contact) : ResponseEntity.status(404).body("Error: Contact with ID " + id + " not found.");
    }

    @PostMapping("/create")
    public ResponseEntity<AddressBookModel> createContact(@Valid @RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(service.createContact(dto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AddressBookModel> updateContact(@PathVariable Long id, @Valid @RequestBody AddressBookDTO dto) {
        AddressBookModel result = service.updateContact(id, dto);
        return result != null ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        if (service.getContactById(id) == null) {
            return ResponseEntity.status(404).body("Error: Contact with ID " + id + " not found.");
        }
        service.deleteContact(id);
        return ResponseEntity.ok("Successfully deleted contact with ID: " + id);
    }
}