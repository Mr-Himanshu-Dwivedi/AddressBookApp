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
    private String name;
    private String phone;
    private String email;
}