package peaksoft.service.impl;

import peaksoft.dao.HospitalDao;
import peaksoft.dao.impl.PatientDaoImpl;
import peaksoft.models.Hospital;
import peaksoft.models.Patient;
import peaksoft.service.GenericService;
import peaksoft.service.PatientService;

import java.util.*;

public class PatientServiceImpl implements PatientService, GenericService<Patient> {
    private final PatientDaoImpl patientDao;
    private final HospitalDao hospitalDao;

    public PatientServiceImpl(PatientDaoImpl patientDao, HospitalDao hospitalDao) {
        this.patientDao = patientDao;
        this.hospitalDao = hospitalDao;
    }

    @Override
    public String add(Long hospitalId, Patient patient) {
        try {
            Hospital hospital = hospitalDao.getHospitalById(hospitalId);
            hospital.getPatients().add(patient);
            patientDao.add(patient);
            return "Patient successfully added";
        } catch (Exception e) {
            throw new RuntimeException("Error adding patient to hospital with id " + hospitalId + ": " + e.getMessage(), e);
        }
    }

    @Override
    public Patient getById(Long id) {
        try {
            return patientDao.getById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error getting patient by id: " + e.getMessage(), e);
        }
    }

    @Override
    public void removeById(Long id) {
        try {
            Hospital foundHospital = null;
            for (Hospital hospital : hospitalDao.getAllHospitals()) {
                for (Patient patient : hospital.getPatients()) {
                    if (patient.getId().equals(id)) {
                        foundHospital = hospital;
                        break;
                    }
                }
                if (foundHospital != null) {
                    break;
                }
            }
            Patient patient = getById(id);
            foundHospital.getPatients().remove(patient);
            patientDao.removeById(id);
            System.out.println("Patient successfully removed");
        } catch (NoSuchElementException e) {
            System.err.println("Error removing patient: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error while removing patient: " + e.getMessage(), e);
        }
    }

    @Override
    public String updateById(Long id, Patient patient) {
        try {
            Patient foundPatient = getById(id);
            foundPatient.setFirstName(patient.getFirstName());
            foundPatient.setLastName(patient.getLastName());
            foundPatient.setAge(patient.getAge());
            foundPatient.setGender(patient.getGender());
            return "Patient successfully updated";
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(e);
        } catch (Exception e) {
            throw new RuntimeException("Error updating patient: " + e.getMessage(), e);
        }
    }

    @Override
    public List<String> addPatientsToHospital(Long hospitalId, List<Patient> patients) {
        try {
            Hospital hospital = hospitalDao.getHospitalById(hospitalId);
            List<String> result = new ArrayList<>();
            for (Patient patient : patients) {
                hospital.getPatients().add(patient);
                patientDao.add(patient);
                Long patientId = patient.getId();
                result.add("Patient with id: " + patientId + " successfully added");
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Error adding patients to hospital: " + e.getMessage(), e);
        }
    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {
        try {
            List<Patient> allPatients = patientDao.getAllPatients();
            Map<Integer, Patient> patientByAge = new HashMap<>();
            for (Patient patient : allPatients) {
                int age = patient.getAge();
                if (!patientByAge.containsKey(age)) {
                    patientByAge.put(age, patient);
                }
            }
            return patientByAge;
        } catch (Exception e) {
            throw new RuntimeException("Error getting patients by age: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        try {
            List<Patient> allPatients = patientDao.getAllPatients();
//            allPatients.sort(new SortPatientsByAge());
//            Comparator<Patient> comparator = ((o1, o2) -> o1.getAge() - o2.getAge());
            Comparator<Patient> comparator = Comparator.comparingInt(Patient::getAge);
            allPatients.sort(comparator);
            if ("desc".equalsIgnoreCase(ascOrDesc)) {
                allPatients = allPatients.reversed();
            }
            return allPatients;
        } catch (Exception e) {
            throw new RuntimeException("Error sorting patients by age: " + e.getMessage(), e);
        }
    }
}
