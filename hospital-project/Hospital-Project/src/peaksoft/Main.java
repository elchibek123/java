package peaksoft;

import peaksoft.dao.HospitalDao;
import peaksoft.dao.impl.DepartmentDaoImpl;
import peaksoft.dao.impl.DoctorDaoImpl;
import peaksoft.dao.impl.HospitalDaoImpl;
import peaksoft.dao.impl.PatientDaoImpl;
import peaksoft.db.Database;
import peaksoft.constants.Gender;
import peaksoft.models.Department;
import peaksoft.models.Doctor;
import peaksoft.models.Hospital;
import peaksoft.models.Patient;
import peaksoft.service.HospitalService;
import peaksoft.service.impl.DepartmentServiceImpl;
import peaksoft.service.impl.DoctorServiceImpl;
import peaksoft.service.impl.HospitalServiceImpl;
import peaksoft.service.impl.PatientServiceImpl;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();

        HospitalDao hospitalDao = new HospitalDaoImpl(database);
        HospitalService hospitalService = new HospitalServiceImpl(hospitalDao);

        DepartmentDaoImpl departmentDao = new DepartmentDaoImpl(database);
        DepartmentServiceImpl departmentService = new DepartmentServiceImpl(departmentDao, hospitalDao);

        DoctorDaoImpl doctorDao = new DoctorDaoImpl(database);
        DoctorServiceImpl doctorService = new DoctorServiceImpl(doctorDao, hospitalDao, departmentDao);

        PatientDaoImpl patientDao = new PatientDaoImpl(database);
        PatientServiceImpl patientService = new PatientServiceImpl(patientDao, hospitalDao);

////////// HOSPITAL

        // Add hospital
        System.out.println(hospitalService.addHospital(new Hospital("Swedish", "Bishkek", new ArrayList<Department>(), new ArrayList<Doctor>(), new ArrayList<Patient>())));
        System.out.println(hospitalService.addHospital(new Hospital("Advocate", "Bishkek", new ArrayList<Department>(), new ArrayList<Doctor>(), new ArrayList<Patient>())));

        // Get all hospitals
        try {
            for (Hospital hospital : hospitalService.getAllHospitals()) {
                System.out.println(hospital);
            }
        } catch (NoSuchElementException e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Find hospital by id
        try {
            System.out.println("Hospital by id: " + hospitalService.getHospitalById(3L));
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        // Get all patients from hospital
        System.out.println("Patients of the hospital: " + hospitalService.getAllPatientsFromHospital(2L));

        // Delete hospital by id
        System.out.println(hospitalService.deleteHospitalById(2L));

        // Get all hospitals by address
//        Map<String, Hospital> allHospitals = hospitalService.getAllHospitalsByAddress("Bishkek");
//        for (Map.Entry<String, Hospital> hospital : allHospitals.entrySet()) {
//            System.out.println(hospital.getKey() + " : " + hospital.getValue());
//        }

        Map<String, List<Hospital>> allHospitals = hospitalService.getAllHospitalsByAddress("Bishkek");
        for (Map.Entry<String, List<Hospital>> entry : allHospitals.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println("Hospitals: [");
            for (Hospital hospital : entry.getValue()) {
                System.out.println(hospital);
            }
            System.out.println("]");
        }

////////// DEPARTMENT

        // Add department
        System.out.println(departmentService.add(1L, new Department("Cardiology", new ArrayList<Doctor>())));
        System.out.println(departmentService.add(1L, new Department("Emergency", new ArrayList<Doctor>())));

        // Get department by name
        try {
            System.out.println(departmentService.getDepartmentByName("Emergency"));
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
        }

        // Remove department by id
        departmentService.removeById(1L);

        // Get all departments by hospital
        List<Department> allDepartmentsByHospital = departmentService.getAllDepartmentsByHospital(1L);
        System.out.println("Departments: [");
        for (Department department : allDepartmentsByHospital) {
            System.out.println(department);
        }
        System.out.println("]");

        // Update department by id
        try {
            System.out.println(departmentService.updateById(2L, new Department("Neurology", new ArrayList<Doctor>())));
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
        }

        // Get department by id
        try {
            System.out.println(departmentService.getById(2L));
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
        }

////////// DOCTOR

        // Add doctor
        System.out.println(doctorService.add(1L, new Doctor("John", "Doe", Gender.MALE, 5)));
        System.out.println(doctorService.add(1L, new Doctor("David", "Smith", Gender.MALE, 5)));

        // Get doctor by id
        try {
            System.out.println(doctorService.getById(1L));
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
        }

        // Assign doctor(s) to department
        List<Long> doctorsId = new ArrayList<>(Arrays.asList(1L, 2L));
        System.out.println(doctorService.assignDoctorToDepartment(2L, doctorsId));

        // Get doctors by hospital id
        for (Doctor doctor : doctorService.getDoctorsByHospitalId(1L)) {
            System.out.println(doctor);
        }

        // Get doctors by department id
        for (Doctor doctor : doctorService.getDoctorsByDepartmentId(2L)) {
            System.out.println(doctor);
        }

        // Remove doctor by id
        doctorService.removeById(1L);

        // Update doctor by id
        try {
            System.out.println(doctorService.updateById(2L, new Doctor("New", "Doctor", Gender.FEMALE, 8)));
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
        }

        // Get doctors by department id
        for (Doctor doctor : doctorService.getDoctorsByDepartmentId(2L)) {
            System.out.println(doctor);
        }

////////// PATIENT

        // Add patient
        try {
            System.out.println(patientService.add(1L, new Patient("Second", "Patient", 32, Gender.FEMALE)));
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        // Add multiple patients
        List<Patient> patients = new ArrayList<>(Arrays.asList(
                new Patient("First", "Patient", 53, Gender.MALE),
                new Patient("Third", "Patient", 24, Gender.MALE),
                new Patient("Sixth", "Patient", 62, Gender.MALE),
                new Patient("Fifth", "Patient", 25, Gender.FEMALE)
        )
        );
        try {
            for (String string : patientService.addPatientsToHospital(1L, patients)) {
                System.out.println(string);
            }
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        // Get patient by id
        try {
            System.out.println(patientService.getById(4L));
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        // Remove patient by id
        try {
            patientService.removeById(4L);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        // Update patient by id
        try {
            System.out.println(patientService.updateById(3L, new Patient("Fourth", "Patient", 37, Gender.MALE)));
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        // Get patient by age
        try {
            Map<Integer, Patient> patientMap = patientService.getPatientByAge();
            for (Map.Entry<Integer, Patient> patientEntry : patientMap.entrySet()) {
                System.out.println(patientEntry.getKey() + " : " + patientEntry.getValue());
            }
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        // Sort patients by age
        try {
            List<Patient> allPatients = patientService.sortPatientsByAge("desc");
            for (Patient patient : allPatients) {
                System.out.println(patient);
            }
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        int i = 1;
        for (Patient patient : hospitalService.getAllPatientsFromHospital(1L)) {
            System.out.println(i++ + " : " + patient);
        }
    }
}