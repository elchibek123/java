package peaksoft.dao.impl;

import peaksoft.dao.HospitalDao;
import peaksoft.db.Database;
import peaksoft.models.Hospital;
import peaksoft.models.IdGenerator;
import peaksoft.models.Patient;

import java.util.List;
import java.util.NoSuchElementException;

public class HospitalDaoImpl implements HospitalDao {
    private final Database database;

    public HospitalDaoImpl(Database database) {
        this.database = database;
    }

    @Override
    public void addHospital(Hospital hospital) {
        hospital.setId(IdGenerator.getHospitalId());
        database.hospitals.add(hospital);
    }

    @Override
    public Hospital getHospitalById(Long id) {
        for (Hospital hospital : database.hospitals) {
            if (hospital.getId().equals(id)) {
                return hospital;
            }
        }
        throw new NoSuchElementException("Hospital with id " + id + " not found");
    }

    @Override
    public List<Hospital> getAllHospitals() {
        if (!database.hospitals.isEmpty()) {
            return database.hospitals;
        }
        throw new NoSuchElementException("No hospital available");
    }

    @Override
    public List<Patient> getAllPatientsFromHospital(Long id) {
        Hospital hospital = getHospitalById(id);
        return hospital.getPatients();
    }

    @Override
    public void deleteHospitalById(Long id) {
        Hospital hospital = getHospitalById(id);
        database.hospitals.remove(hospital);
    }
}
