package com.app.addressapp.service;

import com.app.addressapp.model.AddressBookModel;
import java.util.List;

public interface AddressBookService {
    List<AddressBookModel> getAllContacts();
    AddressBookModel getContactById(Long id);
    AddressBookModel createContact(AddressBookModel contact);
    AddressBookModel updateContact(Long id, AddressBookModel contact);
    void deleteContact(Long id);
}
