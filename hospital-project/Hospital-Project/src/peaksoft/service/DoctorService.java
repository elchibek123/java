package peaksoft.service;

import peaksoft.models.Doctor;

import java.util.List;

public interface DoctorService {
    String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId);

    List<Doctor> getDoctorsByHospitalId(Long hospitalId);

    List<Doctor> getDoctorsByDepartmentId(Long departmentId);
}
