package com.revature.bank.application;

import java.util.List;

/**
 * D - Data
 * A - Access
 * O - Object
 *
 *  A Design pattern for data access, or our persistence layer repositories
 *
 *  What artifact in Java, allows us to dynamically change a type? -> Generics
 */

public interface DAO<T> {

    void create(T make);

    T getById(int id);

    List<T> getAll();

    void update(T change);

    void deleteById(int id);
}
