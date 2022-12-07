package com.rga.contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.rga.contacts.domain.entities.Contact;
import com.rga.contacts.repositories.ContactsRepository;

@SpringBootApplication
public class ContactsApplication implements CommandLineRunner {

	@Autowired
	ContactsRepository contactsRepository;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(ContactsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.contactsRepository.saveOne(new Contact(1, "ricardo", "6771193284"));
		this.contactsRepository.saveOne(new Contact(2, "eder", "6771117315"));
		this.contactsRepository.saveOne(new Contact(3, "omar", "6771110324"));
	}

}
