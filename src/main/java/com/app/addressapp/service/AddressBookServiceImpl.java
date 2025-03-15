package com.app.addressapp.service;

import com.app.addressapp.dto.AddressBookDTO;
import com.app.addressapp.model.AddressBookModel;
import com.app.addressapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AddressBookServiceImpl implements AddressBookService {

    @Autowired
    private AddressBookRepository repository;

    @Override
    public List<AddressBookModel> getAllContacts() {
        log.info("Fetching all contacts from database");
        return repository.findAll();
    }

    @Override
    public AddressBookModel getContactById(Long id) {
        log.info("Fetching contact with ID: {}", id);
        return repository.findById(id).orElse(null);
    }

    @Override
    public AddressBookModel createContact(AddressBookDTO dto) {
        log.info("Creating contact: {}", dto.getFullName());
        AddressBookModel contact = new AddressBookModel();
        contact.setFullName(dto.getFullName());
        contact.setStreet(dto.getStreet());
        contact.setCity(dto.getCity());
        contact.setState(dto.getState());
        contact.setZipCode(dto.getZipCode());
        contact.setPhoneNumber(dto.getPhoneNumber());
        contact.setEmail(dto.getEmail());
        return repository.save(contact);
    }

    @Override
    public AddressBookModel updateContact(Long id, AddressBookDTO dto) {
        log.info("Updating contact with ID: {}", id);
        if (repository.existsById(id)) {
            AddressBookModel contact = new AddressBookModel();
            contact.setId(id);
            contact.setFullName(dto.getFullName());
            contact.setStreet(dto.getStreet());
            contact.setCity(dto.getCity());
            contact.setState(dto.getState());
            contact.setZipCode(dto.getZipCode());
            contact.setPhoneNumber(dto.getPhoneNumber());
            contact.setEmail(dto.getEmail());
            return repository.save(contact);
        }
        log.warn("Contact with ID {} not found for update", id);
        return null;
    }

    @Override
    public void deleteContact(Long id) {
        log.info("Deleting contact with ID: {}", id);
        repository.deleteById(id);
    }
}

