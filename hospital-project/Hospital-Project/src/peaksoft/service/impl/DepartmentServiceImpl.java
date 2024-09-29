package peaksoft.service.impl;

import peaksoft.dao.HospitalDao;
import peaksoft.dao.impl.DepartmentDaoImpl;
import peaksoft.models.Department;
import peaksoft.models.Hospital;
import peaksoft.service.DepartmentService;
import peaksoft.service.GenericService;

import java.util.List;
import java.util.NoSuchElementException;

public class DepartmentServiceImpl implements DepartmentService, GenericService<Department> {
    private final DepartmentDaoImpl departmentDao;
    private final HospitalDao hospitalDao;

    public DepartmentServiceImpl(DepartmentDaoImpl departmentDao, HospitalDao hospitalDao) {
        this.departmentDao = departmentDao;
        this.hospitalDao = hospitalDao;
    }

    @Override
    public String add(Long hospitalId, Department department) {
        Hospital hospital = hospitalDao.getHospitalById(hospitalId);
        hospital.getDepartments().add(department);
        departmentDao.add(department);
        return "Department successfully added";
    }

    @Override
    public Department getById(Long id) {
        try {
            return departmentDao.getById(id);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(e);
        }
    }

    @Override
    public void removeById(Long id) {
        try {
            Hospital foundHospital = null;
            for (Hospital hospital : hospitalDao.getAllHospitals()) {
                for (Department department : hospital.getDepartments()) {
                    if (department.getId().equals(id)) {
                        foundHospital = hospital;
                        break;
                    }
                }
                if (foundHospital != null) {
                    break;
                }
            }
            Department department = getById(id);
            assert foundHospital != null;
            foundHospital.getDepartments().remove(department);
            departmentDao.removeById(id);
            System.out.println("Department successfully removed");
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public String updateById(Long id, Department department) {
        try {
            Department foundDepartment = getById(id);
            foundDepartment.setDepartmentName(department.getDepartmentName());
            foundDepartment.setDoctors(department.getDoctors());
            return "Department successfully updated";
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error while updating department: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Department> getAllDepartmentsByHospital(Long hospitalId) {
        Hospital hospital = hospitalDao.getHospitalById(hospitalId);
        return hospital.getDepartments();
    }

    @Override
    public Department getDepartmentByName(String name) {
        try {
            return departmentDao.getDepartmentByName(name);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error while getting department: " + e.getMessage(), e);
        }
    }
}
