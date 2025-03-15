package com.app.addressapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AddressBookDTO {
    @Pattern(regexp = "^[A-Z][a-zA-Z ]{2,}$", message = "Full Name must start with a capital letter and have at least 3 characters")
    @NotBlank(message = "Name is required")
    private String fullName;

    @NotBlank(message = "Street is required")
    private String street;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State is required")
    private String state;

    @NotBlank(message = "Zip Code is required")
    @Pattern(regexp = "\\d{6}", message = "Zip Code must be a 6-digit number")
    private String zipCode;

    @NotBlank(message = "Phone Number is required")
    @Pattern(regexp = "\\d{10}", message = "Phone Number must be a 10-digit number")
    private String phoneNumber;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;
}