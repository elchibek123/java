package peaksoft.dao;

import peaksoft.models.Patient;

import java.util.List;

public interface PatientDao {
    List<Patient> getAllPatients();
}
