package peaksoft.dao.impl;

import peaksoft.dao.DoctorDao;
import peaksoft.dao.GenericDao;
import peaksoft.db.Database;
import peaksoft.models.Doctor;
import peaksoft.models.IdGenerator;

import java.util.NoSuchElementException;

public class DoctorDaoImpl implements DoctorDao, GenericDao<Doctor> {
    private final Database database;

    public DoctorDaoImpl(Database database) {
        this.database = database;
    }

    @Override
    public void add(Doctor doctor) {
        doctor.setId(IdGenerator.getDoctorId());
        database.doctors.add(doctor);
    }

    @Override
    public Doctor getById(Long id) {
        for (Doctor doctor : database.doctors) {
            if (doctor.getId().equals(id)) {
                return doctor;
            }
        }
        throw new NoSuchElementException("Doctor with id " + id + " not found");
    }

    @Override
    public void removeById(Long id) {
        Doctor doctor = getById(id);
        database.doctors.remove(doctor);
    }
}
