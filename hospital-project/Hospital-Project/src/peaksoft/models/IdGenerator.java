package peaksoft.models;

public class IdGenerator {
    private static Long hospitalId = 1L;
    private static Long departmentId = 1L;
    private static Long doctorId = 1L;
    private static Long patientId = 1L;

    public static Long getHospitalId() {
        return hospitalId++;
    }

    public static Long getDepartmentId() {
        return departmentId++;
    }

    public static Long getDoctorId() {
        return doctorId++;
    }

    public static Long getPatientId() {
        return patientId++;
    }
}
