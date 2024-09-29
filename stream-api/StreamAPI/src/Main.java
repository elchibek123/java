import main.java.db.Database;
import main.java.model.Contact;
import main.java.model.Phone;
import main.java.service.ContactService;
import main.java.service.PhoneService;
import main.java.service.impl.ContactServiceImpl;
import main.java.service.impl.PhoneServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();

        PhoneService phoneService = new PhoneServiceImpl(database);

        ContactService contactService = new ContactServiceImpl(phoneService);

////////// PHONE

        // Add phone
        Phone phone1 = new Phone(1L, "IPhone 12", "Apple", new ArrayList<Contact>());
        Phone phone2 = new Phone(2L, "Samsung Galaxy 21S", "Samsung", new ArrayList<Contact>());
        Phone phone3 = new Phone(3L, "IPhone 15 Pro Max", "Apple", new ArrayList<Contact>());
        phoneService.addPhone(phone1);
        phoneService.addPhone(phone2);
        phoneService.addPhone(phone3);

        // Get phone by id
        try {
            System.out.println(phoneService.getPhoneById(2L));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        // Update phone by id
        try {
            Phone phone = phoneService.updatePhoneById(2L, new Phone(2L, "HUAWEI Pura 70 Ultra", "Huawei", new ArrayList<Contact>()));
            System.out.println("Updated phone: " + phone);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        // Get all phones
        try {
            List<Phone> allPhones = phoneService.getAllPhones();
            for (Phone item : allPhones) {
                System.out.println(item);
            }
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        // Get all phones by brand name
        try {
            List<Phone> allPhonesByBrandName = phoneService.getAllPhonesByBrandName("Apple");
            for (Phone item : allPhonesByBrandName) {
                System.out.println("Phone by brand name: " + item);
            }
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        // Delete phone by id
        phoneService.deletePhoneById(1L);

////////// CONTACT

        // Add contact to phone
        Contact contact1 = new Contact("John", 12344567);
        Contact contact2 = new Contact("David", 7654321);
        Contact contact3 = new Contact("Mary", 9876543);
        Contact contact4 = new Contact("Richard", 3456789);
        System.out.println(contactService.addContactToPhone(2L, contact1));
        System.out.println(contactService.addContactToPhone(2L, contact2));
        System.out.println(contactService.addContactToPhone(2L, contact3));
        System.out.println(contactService.addContactToPhone(2L, contact4));

        // Get contact by name
        try {
            Contact contactByName = contactService.getContactByName(2L, "David");
            System.out.println("Contact by name: " + contactByName);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        // Get contact by phone number
        try {
            Contact contactByPhoneNumber = contactService.getContactByPhoneNumber(2L, 12344567);
            System.out.println("Contact by phone number: " + contactByPhoneNumber);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        // Sort contacts by name
        try {
            List<Contact> contacts = contactService.sortContactsByName(2L);
            System.out.println("Contacts sorted by name: ");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }
}
