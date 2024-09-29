package peaksoft.models;

import java.util.List;

public class Hospital {
    private Long id;
    private String name;
    private String address;
    private List<Department> departments;
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital(String name, String address, List<Department> departments, List<Doctor> doctors, List<Patient> patients) {
        this.name = name;
        this.address = address;
        this.departments = departments;
        this.doctors = doctors;
        this.patients = patients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", departments=" + departments +
                ", doctors=" + doctors +
                ", patients=" + patients +
                '}';
    }
}
