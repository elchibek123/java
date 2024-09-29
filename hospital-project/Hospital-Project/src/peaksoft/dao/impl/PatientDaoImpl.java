package peaksoft.dao.impl;

import peaksoft.dao.GenericDao;
import peaksoft.dao.PatientDao;
import peaksoft.db.Database;
import peaksoft.models.IdGenerator;
import peaksoft.models.Patient;

import java.util.List;
import java.util.NoSuchElementException;

public class PatientDaoImpl implements PatientDao, GenericDao<Patient> {
    private final Database database;

    public PatientDaoImpl(Database database) {
        this.database = database;
    }

    @Override
    public void add(Patient patient) {
        patient.setId(IdGenerator.getPatientId());
        database.patients.add(patient);
    }

    @Override
    public Patient getById(Long id) {
        for (Patient patient : database.patients) {
            if (patient.getId().equals(id)) {
                return patient;
            }
        }
        throw new NoSuchElementException("Patient with id " + id + " not found");
    }

    @Override
    public void removeById(Long id) {
        Patient patient = getById(id);
        database.patients.remove(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return database.patients;
    }
}
