package com.rga.contacts.services;

import java.util.List;

import com.rga.contacts.domain.entities.Contact;

public interface ContactsService {

    List<Contact> findAll();
    Contact findOneById(Integer id);
    Integer saveOne(Contact contact);
    Integer deleteOne(Integer id);
    Integer deleteOne(Contact contact);
}
