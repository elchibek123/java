package peaksoft.service;

import peaksoft.models.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartmentsByHospital(Long hospitalId);

    Department getDepartmentByName(String name);
}
