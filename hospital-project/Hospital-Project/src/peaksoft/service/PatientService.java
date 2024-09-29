package peaksoft.service;

import peaksoft.models.Patient;

import java.util.List;
import java.util.Map;

public interface PatientService {
    List<String> addPatientsToHospital(Long hospitalId, List<Patient> patients);

    Map<Integer, Patient> getPatientByAge();

    List<Patient> sortPatientsByAge(String ascOrDesc);
}
