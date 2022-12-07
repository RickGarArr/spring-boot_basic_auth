package com.rga.contacts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rga.contacts.services.ContactsService;
import com.rga.contacts.domain.entities.Contact;
import java.util.*;

import javax.validation.Valid;

@RestController
@RequestMapping("contacts")
public class ContactsController {
    
    @Autowired
    private ContactsService contactsService;

    @GetMapping("")
    public ResponseEntity<List<Contact>> getContacts() {
        List<Contact> contacts = this.contactsService.findAll();
        return new ResponseEntity<List<Contact>>(contacts, HttpStatus.OK);
    }

    @GetMapping("/{contact-id}")
    public ResponseEntity<Contact> getContact(@PathVariable(name = "contact-id") Integer contactID) {
        Contact contact = this.contactsService.findOneById(contactID);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Contact> createContact(@Valid @RequestBody Contact contact) {
        this.contactsService.saveOne(contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{contact-id}/contact") // path was changed to demo antMatchers
    public ResponseEntity<Contact> deleteContact(@PathVariable(name = "contact-id") Integer contactID) {
        Contact contact = this.contactsService.findOneById(contactID);
        this.contactsService.deleteOne(contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }
    
}
