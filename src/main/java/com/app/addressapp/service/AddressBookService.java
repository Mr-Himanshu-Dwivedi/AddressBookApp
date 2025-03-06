package com.app.addressapp.service;

import com.app.addressapp.dto.AddressBookDTO;
import com.app.addressapp.model.AddressBookModel;
import java.util.List;

public interface AddressBookService {
    List<AddressBookModel> getAllContacts();
    AddressBookModel getContactById(Long id);
    AddressBookModel createContact(AddressBookDTO dto);
    AddressBookModel updateContact(Long id, AddressBookDTO dto);
    void deleteContact(Long id);
}