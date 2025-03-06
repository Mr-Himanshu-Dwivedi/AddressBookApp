package com.app.addressapp.repository;

import com.app.addressapp.model.AddressBookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<AddressBookModel, Long> {
}