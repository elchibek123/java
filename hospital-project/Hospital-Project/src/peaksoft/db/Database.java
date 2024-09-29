package peaksoft.db;

import peaksoft.models.Department;
import peaksoft.models.Doctor;
import peaksoft.models.Hospital;
import peaksoft.models.Patient;

import java.util.ArrayList;
import java.util.List;

public class Database {
    public List<Hospital> hospitals = new ArrayList<>();
    public List<Department> departments = new ArrayList<>();
    public List<Doctor> doctors = new ArrayList<>();
    public List<Patient> patients = new ArrayList<>();
}
