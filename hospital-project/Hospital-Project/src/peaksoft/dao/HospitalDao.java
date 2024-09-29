package peaksoft.dao;

import peaksoft.models.Hospital;
import peaksoft.models.Patient;

import java.util.List;

public interface HospitalDao {
    void addHospital(Hospital hospital);

    Hospital getHospitalById(Long id);

    List<Hospital> getAllHospitals();

    List<Patient> getAllPatientsFromHospital(Long id);

    void deleteHospitalById(Long id);
}
