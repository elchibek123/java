package main.java.service;

import main.java.model.Contact;

import java.util.List;

public interface ContactService {
    String addContactToPhone(Long phoneId, Contact contact1);

    Contact getContactByName(Long phoneId, String name);

    Contact getContactByPhoneNumber(Long phoneId, int phoneNumber);

    List<Contact> sortContactsByName(Long phoneId);
}
