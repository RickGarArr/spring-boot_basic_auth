package com.rga.contacts.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rga.contacts.domain.entities.Contact;
import com.rga.contacts.repositories.ContactsRepository;
import com.rga.contacts.services.ContactsService;

@Service
public class ContactsServiceImp implements ContactsService {

    @Autowired
    private ContactsRepository contactsRepository;

    @Override
    public List<Contact> findAll() {
        return this.contactsRepository.findAll();
    }

    @Override
    public Contact findOneById(Integer id) {
        return this.contactsRepository.findOneById(id);
    }

    @Override
    public Integer saveOne(Contact contact) {
        return this.contactsRepository.saveOne(contact);
    }

    @Override
    public Integer deleteOne(Integer id) {
        return this.contactsRepository.deleteOne(id);
    }

    @Override
    public Integer deleteOne(Contact contact) {
        return this.contactsRepository.deleteOne(contact);
    }
    
}
