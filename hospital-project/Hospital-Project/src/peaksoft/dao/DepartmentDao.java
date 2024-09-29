package peaksoft.dao;

import peaksoft.models.Department;

public interface DepartmentDao {
    Department getDepartmentByName(String name);
}
