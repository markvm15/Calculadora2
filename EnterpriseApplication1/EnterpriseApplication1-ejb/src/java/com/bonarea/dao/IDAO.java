/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bonarea.dao;

import com.bonarea.model.Student;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author marcv
 * @param <T>
 */
public interface IDAO<T> {

    /**
     *
     * @param model
     * @return Student
     * @throws SQLException
     */
    public int add(T model) throws SQLException;
    public int delete(T model) throws SQLException;
    public int update(T model) throws SQLException;
    public List<Student> getAll() throws SQLException;
}
