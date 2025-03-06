package com.app.addressapp.controller;

import com.app.addressapp.model.AddressBookModel;
import com.app.addressapp.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressBookController {

    @Autowired
    private AddressBookService service;

    @GetMapping("/")
    public String sayHello() {
        return "Welcome to the Address Book App!";
    }

    @GetMapping("/all")
    public List<AddressBookModel> getAllContacts() {
        return service.getAllContacts();
    }

    @GetMapping("/get/{id}")
    public AddressBookModel getContact(@PathVariable Long id) {
        return service.getContactById(id);
    }

    @PostMapping("/create")
    public AddressBookModel createContact(@RequestBody AddressBookModel contact) {
        return service.createContact(contact);
    }

    @PutMapping("/update/{id}")
    public AddressBookModel updateContact(@PathVariable Long id, @RequestBody AddressBookModel contact) {
        return service.updateContact(id, contact);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteContact(@PathVariable Long id) {
        service.deleteContact(id);
        return "Successfully deleted contact with ID: " + id;
    }
}
