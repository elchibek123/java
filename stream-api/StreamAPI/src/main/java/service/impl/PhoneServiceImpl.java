package main.java.service.impl;

import main.java.db.Database;
import main.java.exceptions.DatabaseAccessException;
import main.java.exceptions.PhoneNotFoundException;
import main.java.model.Phone;
import main.java.service.PhoneService;

import java.util.List;
import java.util.stream.Collectors;

public class PhoneServiceImpl implements PhoneService {
    private final Database database;

    public PhoneServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public String addPhone(Phone phone) {
        database.phones.add(phone);
        return "Phone successfully added";
    }

    @Override
    public Phone getPhoneById(Long id) {
        return database.phones.stream()
                .filter(phone -> phone.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new PhoneNotFoundException("Phone with ID " + id + " not found"));
    }

    @Override
    public Phone updatePhoneById(Long id, Phone phone) {
        try {
            Phone phoneById = getPhoneById(id);
            phoneById.setId(phone.getId());
            phoneById.setName(phone.getName());
            phoneById.setBrand(phone.getBrand());
            phoneById.setContacts(phone.getContacts());
            return phoneById;
        } catch (PhoneNotFoundException e) {
            System.err.println("Phone not found: " + e.getMessage());
            throw e;
        } catch (RuntimeException e) {
            System.err.println("Error updating phone: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Phone> getAllPhones() {
        try {
            if (database == null || database.phones == null) {
                throw new DatabaseAccessException("Database is unavailable");
            }
            return database.phones;
        } catch (RuntimeException e) {
            System.err.println("Error accessing phones: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Phone> getAllPhonesByBrandName(String brand) {
        try {
            List<Phone> phonesByBrand = getAllPhones().stream()
                    .filter(phone -> phone.getBrand().equalsIgnoreCase(brand))
                    .collect(Collectors.toList());
            if (phonesByBrand.isEmpty()) {
                throw new PhoneNotFoundException("No phones found for brand: " + brand);
            }
            return phonesByBrand;
        } catch (PhoneNotFoundException e) {
            System.err.println("Phone not found: " + e.getMessage());
            throw e;
        } catch (RuntimeException e) {
            System.err.println("Error getting phones by brand: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void deletePhoneById(Long id) {
        try {
            Phone phoneById = getPhoneById(id);
            database.phones.remove(phoneById);
            System.out.println("Phone successfully deleted");
        } catch (Exception e) {
            System.err.println("Error deleting phone by ID: " + e.getMessage());
        }
    }
}
