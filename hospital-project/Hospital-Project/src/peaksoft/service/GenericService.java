package peaksoft.service;

public interface GenericService<T> {
    String add(Long hospitalId, T t);

    T getById(Long id);

    void removeById(Long id);

    String updateById(Long id, T t);
}
