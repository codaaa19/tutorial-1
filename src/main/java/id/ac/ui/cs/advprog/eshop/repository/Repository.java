package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Car;

import java.util.ArrayList;
import java.util.List;

public interface Repository<T> {
    static int id = 0;

    T create(T inventory);
    T delete(String id);
    List<T> findAll();
    T findById(String id);
    T update(String id, T updated);
}