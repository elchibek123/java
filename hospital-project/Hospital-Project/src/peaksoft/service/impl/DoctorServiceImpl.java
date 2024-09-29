package peaksoft.service.impl;

import peaksoft.dao.HospitalDao;
import peaksoft.dao.impl.DepartmentDaoImpl;
import peaksoft.dao.impl.DoctorDaoImpl;
import peaksoft.models.Department;
import peaksoft.models.Doctor;
import peaksoft.models.Hospital;
import peaksoft.service.DoctorService;
import peaksoft.service.GenericService;

import java.util.List;
import java.util.NoSuchElementException;

public class DoctorServiceImpl implements DoctorService, GenericService<Doctor> {
    private final DoctorDaoImpl doctorDao;
    private final HospitalDao hospitalDao;
    private final DepartmentDaoImpl departmentDao;

    public DoctorServiceImpl(DoctorDaoImpl doctorDao, HospitalDao hospitalDao, DepartmentDaoImpl departmentDao) {
        this.doctorDao = doctorDao;
        this.hospitalDao = hospitalDao;
        this.departmentDao = departmentDao;
    }

    @Override
    public String add(Long hospitalId, Doctor doctor) {
        Hospital hospital = hospitalDao.getHospitalById(hospitalId);
        hospital.getDoctors().add(doctor);
        doctorDao.add(doctor);
        return "Doctor successfully added";
    }

    @Override
    public Doctor getById(Long id) {
        try {
            return doctorDao.getById(id);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(e);
        }
    }

    @Override
    public void removeById(Long id) {
        try {
            Hospital foundHospital = null;
            Doctor foundDoctor = null;
            for (Hospital hospital : hospitalDao.getAllHospitals()) {
                for (Doctor doctor : hospital.getDoctors()) {
                    if (doctor.getId().equals(id)) {
                        foundHospital = hospital;
                        foundDoctor = doctor;
                    }
                }
            }

            Department foundDepartment = null;
            assert foundHospital != null;
            for (Department department : foundHospital.getDepartments()) {
                for (Doctor doctor : department.getDoctors()) {
                    if (doctor.getId().equals(id)) {
                        foundDepartment = department;
                        break;
                    }
                }
                if (foundDepartment != null) {
                    break;
                }
            }
            assert foundDepartment != null;

            foundDepartment.getDoctors().remove(foundDoctor);
            foundHospital.getDoctors().remove(foundDoctor);
            doctorDao.removeById(id);
            System.out.println("Doctor successfully removed");
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public String updateById(Long id, Doctor doctor) {
        try {
            Doctor foundDoctor = getById(id);
            foundDoctor.setFirstName(doctor.getFirstName());
            foundDoctor.setLastName(doctor.getLastName());
            foundDoctor.setGender(doctor.getGender());
            foundDoctor.setExperienceYear(doctor.getExperienceYear());
            return "Doctor successfully updated";
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(e);
        }
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        Department department = departmentDao.getById(departmentId);
        for (Hospital hospital : hospitalDao.getAllHospitals()) {
            for (Doctor doctor : hospital.getDoctors()) {
                for (Long doctorId : doctorsId) {
                    if (doctor.getId().equals(doctorId)) {
                        department.getDoctors().add(doctor);
                    }
                }
            }
        }
        return "Doctor(s) successfully assigned to the department";
    }

    @Override
    public List<Doctor> getDoctorsByHospitalId(Long hospitalId) {
        Hospital hospital = hospitalDao.getHospitalById(hospitalId);
        return hospital.getDoctors();
    }

    @Override
    public List<Doctor> getDoctorsByDepartmentId(Long departmentId) {
        Department department = departmentDao.getById(departmentId);
        return department.getDoctors();
    }
}
