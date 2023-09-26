package org.julio.java.jdbc.repositories;

import java.sql.SQLException;
import java.util.List;

/**
 * The interface Repository.
 *
 * @param <T> the type parameter
 */
public interface Repository <T> {

    /**
     * List list.
     *
     * @return the list
     * @throws SQLException the sql exception
     */
    List<T> list() throws SQLException;

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     * @throws SQLException the sql exception
     */
    T getById(Long id) throws SQLException;

    /**
     * Save.
     *
     * @param t the t
     * @throws SQLException the sql exception
     */
    void save(T t) throws SQLException;

    /**
     * Delete.
     *
     * @param id the id
     * @throws SQLException the sql exception
     */
    void delete(Long id) throws SQLException;



}
