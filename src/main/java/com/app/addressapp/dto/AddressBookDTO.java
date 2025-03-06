package com.app.addressapp.dto;

import lombok.Data;

@Data
public class AddressBookDTO {
    private String fullName;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String email;
}