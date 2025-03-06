package com.app.addressapp.service;

import com.app.addressapp.dto.AddressBookDTO;
import com.app.addressapp.model.AddressBookModel;
import com.app.addressapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AddressBookServiceImpl implements AddressBookService {

    @Autowired
    private AddressBookRepository repository;

    @Override
    public List<AddressBookModel> getAllContacts() {
        return repository.findAll();
    }

    @Override
    public AddressBookModel getContactById(Long id) {
        Optional<AddressBookModel> contact = repository.findById(id);
        return contact.orElse(null);
    }

    @Override
    public AddressBookModel createContact(AddressBookDTO dto) {
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
        return null;
    }

    @Override
    public void deleteContact(Long id) {
        repository.deleteById(id);
    }
}
