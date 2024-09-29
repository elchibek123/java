package main.java.service;

import main.java.model.Phone;

import java.util.List;
import java.util.Optional;

public interface PhoneService {
    String addPhone(Phone phone);

    Phone getPhoneById(Long id);

    Phone updatePhoneById(Long id, Phone phone);

    List<Phone> getAllPhones();

    List<Phone> getAllPhonesByBrandName(String brand);

    void deletePhoneById(Long id);
}
