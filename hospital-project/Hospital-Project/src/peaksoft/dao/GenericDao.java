package peaksoft.dao;

public interface GenericDao<T> {
    void add(T t);

    T getById(Long id);

    void removeById(Long id);
}
