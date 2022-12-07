package com.rga.contacts.repositories;

import java.util.*;
import org.springframework.stereotype.Repository;
import com.rga.contacts.domain.entities.Contact;

@Repository
public class ContactsRepository {

    private List<Contact> contacts = new ArrayList<>();

    public List<Contact> findAll() {
        return this.contacts;
    }

    public Contact findOneById(Integer id) {
        return this.contacts.stream().filter(contact -> contact.getId().equals(id)).findAny().get();
    }

    public int saveOne(Contact contact) {
        this.contacts.add(contact);
        return this.contacts.size();
    }

    public int deleteOne(Contact contact) {
        this.contacts.remove(contact);
        return this.contacts.size();
    }

    public int deleteOne(Integer id) {
        this.contacts = this.contacts.stream().filter(contact -> !contact.getId().equals(id)).toList();
        return this.contacts.size();
    }
}
