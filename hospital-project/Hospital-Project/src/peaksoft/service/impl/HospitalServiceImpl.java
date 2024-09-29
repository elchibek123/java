package peaksoft.service.impl;

import peaksoft.dao.HospitalDao;
import peaksoft.models.Hospital;
import peaksoft.models.Patient;
import peaksoft.service.HospitalService;

import java.util.*;

public class HospitalServiceImpl implements HospitalService {
    private final HospitalDao hospitalDao;

    public HospitalServiceImpl(HospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    @Override
    public String addHospital(Hospital hospital) {
        hospitalDao.addHospital(hospital);
        return "Hospital successfully added";
    }

    @Override
    public Hospital getHospitalById(Long id) {
        Hospital foundHospital;
        try {
            foundHospital = hospitalDao.getHospitalById(id);
        } catch (RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
        return foundHospital;
    }

    @Override
    public List<Hospital> getAllHospitals() {
        try {
            return hospitalDao.getAllHospitals();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(e);
        }
    }

    @Override
    public List<Patient> getAllPatientsFromHospital(Long id) {
        return hospitalDao.getAllPatientsFromHospital(id);
    }

    @Override
    public String deleteHospitalById(Long id) {
        try {
            hospitalDao.deleteHospitalById(id);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
        return "Hospital successfully deleted";
    }

//    @Override
//    public Map<String, Hospital> getAllHospitalsByAddress(String address) {
//        Map<String, Hospital> hospitals = new HashMap<>();
//        for (Hospital hospital : hospitalDao.getAllHospitals()) {
//            if (hospital.getAddress().equals(address)) {
//                hospitals.put(address, hospital);
//            }
//        }
//        return hospitals;
//    }

    @Override
    public Map<String, List<Hospital>> getAllHospitalsByAddress(String address) {
        Map<String, List<Hospital>> hospitalsByAddress = new HashMap<>();
        for (Hospital hospital : hospitalDao.getAllHospitals()) {
            if (hospital.getAddress().equals(address)) {
                if (!hospitalsByAddress.containsKey(address)) {
                    hospitalsByAddress.put(address, new ArrayList<>());
                }
                hospitalsByAddress.get(address).add(hospital);
            }
        }
        return hospitalsByAddress;
    }
}
