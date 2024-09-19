package java22.dao;

import java.util.List;

public interface UserDao<T, ID> {
    // CRUD

    // create
    void create(T t);

    // get all
    List<T> getAll();

    // get by ID
    T getById(ID id);

    // update by ID
    void updateById(ID id, T t);

    // delete by ID
    void deleteById(ID id);
}
