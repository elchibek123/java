package peaksoft.service;

import peaksoft.models.Hospital;
import peaksoft.models.Patient;

import java.util.List;
import java.util.Map;

public interface HospitalService {
    String addHospital(Hospital swedish);

    Hospital getHospitalById(Long id);

    List<Hospital> getAllHospitals();

    List<Patient> getAllPatientsFromHospital(Long id);

    String deleteHospitalById(Long id);

//    Map<String, Hospital> getAllHospitalsByAddress(String address);

    Map<String, List<Hospital>> getAllHospitalsByAddress(String address);
}
