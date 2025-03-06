package com.app.addressapp.model;

import lombok.Data;
import jakarta.persistence.*;

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