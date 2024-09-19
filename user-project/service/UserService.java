package java22.service;

import java.util.List;

public interface UserService<T, ID> {
    String save(T object);

    List<T> getAll();

    T getById(ID id);

    T updateById(ID id, T t);

    String deleteById(ID id);
}
