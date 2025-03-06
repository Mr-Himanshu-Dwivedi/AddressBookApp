package com.app.addressapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "address_book")
public class AddressBookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String email;
}