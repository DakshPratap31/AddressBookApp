package com.example.AddressBookApp.controller;

import com.example.AddressBookApp.DTOs.AddressBookDTO;
import com.example.AddressBookApp.model.AddressBook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @GetMapping({"", "/"})
    public ResponseEntity<List<AddressBookDTO>> getAllAddresses() {
        // Converting model to DTO - example for UC1
        List<AddressBookDTO> addressDTOs = new ArrayList<>();
        addressDTOs.add(new AddressBookDTO(1L, "daksh", "G-Block", "Mathura", "NY", "10001", "678781234", "dakshpratap31@gmail.com"));
        addressDTOs.add(new AddressBookDTO(2L, "Divyansu", "H-Block", "Mathura", "CA", "90001", "555-5678", "divyanshutahkur@gmail.com"));

        return new ResponseEntity<>(addressDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressBookDTO> getAddressById(@PathVariable Long id) {
        // Example for UC1
        AddressBookDTO addressDTO = new AddressBookDTO(id, "John Doe", "123 Main St", "New York", "NY", "10001", "555-1234", "john@example.com");
        return new ResponseEntity<>(addressDTO, HttpStatus.OK);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<AddressBookDTO> createAddress(@RequestBody AddressBookDTO addressDTO) {
        // Simulating creating a new address - UC1
        AddressBook addressBook = new AddressBook();
        addressBook.setId(addressDTO.getId());
        addressBook.setName(addressDTO.getName());
        addressBook.setAddress(addressDTO.getAddress());
        addressBook.setCity(addressDTO.getCity());
        addressBook.setState(addressDTO.getState());
        addressBook.setZip(addressDTO.getZip());
        addressBook.setPhone(addressDTO.getPhone());
        addressBook.setEmail(addressDTO.getEmail());

        // Simulating DTO conversion of saved entity
        addressDTO.setId(3L); // Simulating ID generation

        return new ResponseEntity<>(addressDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressBookDTO> updateAddress(@PathVariable Long id, @RequestBody AddressBookDTO addressDTO) {
        // Simulating update - UC1
        addressDTO.setId(id);
        return new ResponseEntity<>(addressDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        // Simple delete response - UC1
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}