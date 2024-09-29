package peaksoft.dao.impl;

import peaksoft.dao.DepartmentDao;
import peaksoft.dao.GenericDao;
import peaksoft.db.Database;
import peaksoft.models.Department;
import peaksoft.models.IdGenerator;

import java.util.NoSuchElementException;

public class DepartmentDaoImpl implements DepartmentDao, GenericDao<Department> {
    private final Database database;


    public DepartmentDaoImpl(Database database) {
        this.database = database;
    }

    @Override
    public void add(Department department) {
        department.setId(IdGenerator.getDepartmentId());
        database.departments.add(department);
    }

    @Override
    public Department getById(Long id) {
        for (Department department : database.departments) {
            if (department.getId().equals(id)) {
                return department;
            }
        }
        throw new NoSuchElementException("Department with id " + id + " not found");
    }

    @Override
    public void removeById(Long id) {
        Department department = getById(id);
        database.departments.remove(department);
    }

    @Override
    public Department getDepartmentByName(String name) {
        for (Department department : database.departments) {
            if (department.getDepartmentName().equals(name)) {
                return department;
            }
        }
        throw new NoSuchElementException("Department with name " + name + " not found");
    }
}
