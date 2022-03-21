package com.codegym.DAO;

import java.util.List;

public interface IGeneralDAO<T> {
    List<T> findAll();

    T findById(int id);

    boolean create(T t);

    boolean deleteById(int id);

    boolean updateById(int id, T t);
}
