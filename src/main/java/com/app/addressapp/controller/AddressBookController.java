package com.app.addressapp.controller;

import com.app.addressapp.dto.AddressBookDTO;
import com.app.addressapp.model.AddressBookModel;
import com.app.addressapp.service.AddressBookService;
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

    @GetMapping("/all")
    public ResponseEntity<List<AddressBookModel>> getAllContacts() {
        return ResponseEntity.ok(service.getAllContacts());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AddressBookModel> getContact(@PathVariable Long id) {
        AddressBookModel contact = service.getContactById(id);
        return contact != null ? ResponseEntity.ok(contact) : ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<AddressBookModel> createContact(@RequestBody AddressBookDTO dto) {
        AddressBookModel contact = new AddressBookModel();
        contact.setFullName(dto.getFullName());
        contact.setStreet(dto.getStreet());
        contact.setCity(dto.getCity());
        contact.setState(dto.getState());
        contact.setZipCode(dto.getZipCode());
        contact.setPhoneNumber(dto.getPhoneNumber());
        contact.setEmail(dto.getEmail());
        return ResponseEntity.ok(service.createContact(contact));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AddressBookModel> updateContact(@PathVariable Long id, @RequestBody AddressBookDTO dto) {
        AddressBookModel updatedContact = new AddressBookModel();
        updatedContact.setFullName(dto.getFullName());
        updatedContact.setStreet(dto.getStreet());
        updatedContact.setCity(dto.getCity());
        updatedContact.setState(dto.getState());
        updatedContact.setZipCode(dto.getZipCode());
        updatedContact.setPhoneNumber(dto.getPhoneNumber());
        updatedContact.setEmail(dto.getEmail());
        AddressBookModel result = service.updateContact(id, updatedContact);
        return result != null ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        service.deleteContact(id);
        return ResponseEntity.ok("Successfully deleted contact with ID: " + id);
    }
}