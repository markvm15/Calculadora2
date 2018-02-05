/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bonarea.service;

import com.bonarea.dao.MySqlDao;
import java.sql.SQLException;
import javax.ejb.Stateless;
import javax.inject.Inject;
import com.bonarea.dao.StudentDao;
import com.bonarea.dao.StudentDaoUniverse;
import com.bonarea.dao.UniverseDao;
import com.bonarea.model.Student;
import java.util.List;
/**
 *
 * @author marcv
 */

@Stateless
public class StudentBean implements StudentBeanLocal {

@Inject
@UniverseDao
StudentDaoUniverse studentDao;

    @Override
    public int add(Object model) throws SQLException {
        return studentDao.add((Student) model);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public int delete(Object model) throws SQLException {
        return studentDao.delete((Student) model);
    }

    @Override
    public int update(Object model) throws SQLException {
        return studentDao.update((Student) model);
    }

    @Override
    public List getAll() throws SQLException {
        return studentDao.getAll();
    }
    
}
