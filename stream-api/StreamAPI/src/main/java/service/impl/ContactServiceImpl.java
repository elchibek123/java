package main.java.service.impl;

import main.java.exceptions.ContactNotFoundException;
import main.java.exceptions.PhoneNotFoundException;
import main.java.model.Contact;
import main.java.model.Phone;
import main.java.service.ContactService;
import main.java.service.PhoneService;

import java.util.List;
import java.util.stream.Collectors;

public class ContactServiceImpl implements ContactService {
    private final PhoneService phoneService;

    public ContactServiceImpl(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @Override
    public String addContactToPhone(Long phoneId, Contact contact1) {
        Phone foundPhone = phoneService.getPhoneById(phoneId);
        foundPhone.getContacts().add(contact1);
        return "Contact successfully added";
    }

    @Override
    public Contact getContactByName(Long phoneId, String name) {
        return phoneService.getPhoneById(phoneId).getContacts().stream()
                .filter(phone -> phone.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new ContactNotFoundException("Contact with name " + name + " not found"));
    }

    @Override
    public Contact getContactByPhoneNumber(Long phoneId, int phoneNumber) {
        return phoneService.getPhoneById(phoneId).getContacts().stream()
                .filter(phone -> phone.getPhoneNumber() == phoneNumber)
                .findFirst()
                .orElseThrow(() -> new ContactNotFoundException("Contact with phone number " + phoneNumber + " not found"));
    }

    @Override
    public List<Contact> sortContactsByName(Long phoneId) {
        try {
            Phone foundPhone = phoneService.getPhoneById(phoneId);
            if (foundPhone.getContacts() == null || foundPhone.getContacts().isEmpty()) {
                throw new ContactNotFoundException("No contacts found for phone with ID " + phoneId);
            }
            return foundPhone.getContacts().stream()
                    .sorted((contact1, contact2) -> contact1.getName().compareToIgnoreCase(contact2.getName()))
                    .collect(Collectors.toList());
        } catch (PhoneNotFoundException e) {
            System.err.println("Phone not found: " + e.getMessage());
            throw e;
        } catch (ContactNotFoundException e) {
            System.err.println("Contact not found: " + e.getMessage());
            throw e;
        } catch (RuntimeException e) {
            System.err.println("Error sorting contacts: " + e.getMessage());
            throw new RuntimeException("An error occurred while sorting contacts.", e);
        }
    }
}
