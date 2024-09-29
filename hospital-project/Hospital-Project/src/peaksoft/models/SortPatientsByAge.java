package peaksoft.models;

import java.util.Comparator;

public class SortPatientsByAge implements Comparator<Patient> {

    @Override
    public int compare(Patient o1, Patient o2) {
        return o1.getAge() - o2.getAge();
    }
}
