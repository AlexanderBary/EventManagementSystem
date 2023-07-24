package ru.alexanderbary.ems.dao;

import java.util.List;
import java.util.Optional;

public interface Dao <T> {

    List<T> getAll();
    Optional<T> getById(Long id);
    void save(T t);
    void delete(T t);
    void update(T t);
}
