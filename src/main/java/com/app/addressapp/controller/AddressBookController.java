package com.app.addressapp.controller;

import com.app.addressapp.model.AddressBookModel;
import com.app.addressapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AddressBookController {

    @Autowired
    private AddressBookRepository repository;

    @GetMapping("/")
    public String sayHello() {
        return "Welcome to the Address Book App!";
    }

    @GetMapping("/all")
    public List<AddressBookModel> getAllContacts() {
        return repository.findAll();
    }

    @GetMapping("/get/{id}")
    public AddressBookModel getContact(@PathVariable Long id) {
        Optional<AddressBookModel> contact = repository.findById(id);
        return contact.orElse(null);
    }

    @PostMapping("/create")
    public AddressBookModel createContact(@RequestBody AddressBookModel contact) {
        return repository.save(contact);
    }

    @PutMapping("/update/{id}")
    public AddressBookModel updateContact(@PathVariable Long id, @RequestBody AddressBookModel contact) {
        if (repository.existsById(id)) {
            contact.setId(id);
            return repository.save(contact);
        }
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteContact(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Successfully deleted contact with ID: " + id;
        }
        return "Contact not found with ID: " + id;
    }
}
