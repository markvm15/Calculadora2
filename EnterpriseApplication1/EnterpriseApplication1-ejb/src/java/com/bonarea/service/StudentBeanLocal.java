/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bonarea.service;


import com.bonarea.model.Student;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marcv
 * @param <T>
 */
@Local
public interface StudentBeanLocal<T> {
    public int add(T model) throws SQLException;
    public int delete(T model) throws SQLException;
    public int update(T model) throws SQLException;
    public List<Student> getAll() throws SQLException;
}
