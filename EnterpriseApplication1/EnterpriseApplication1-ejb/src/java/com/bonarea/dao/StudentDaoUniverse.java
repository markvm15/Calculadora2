/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bonarea.dao;

import com.bonarea.model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.sql.DataSource;

/**
 *
 * @author marcv
 */
@RequestScoped
@UniverseDao
public class StudentDaoUniverse implements IDAO<Student>{
    @Resource(name="jdbc/Universe")
    private DataSource dataSource;

    @Override
    public int add(Student model) throws SQLException {
        int files;
        try (Connection con = dataSource.getConnection()) {
            String q1 = "SELECT MAX(student_id) from student";
            PreparedStatement ps = con.prepareStatement(q1);
            ResultSet rs = ps.executeQuery();
            int id = 0;
            if(!rs.wasNull()){
                rs.next();
                id = rs.getInt(1)+1;
            }else{
                id = 1;
            }
            String query = "INSERT INTO student (student_id,name,surname,dni) VALUES (?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, model.getName());
            ps.setString(3, model.getSurname());
            ps.setString(4, model.getCard_id());
            files = ps.executeUpdate();
            con.close();
        }
        return files;
    }

    @Override
    public int delete(Student model) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Student model) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Student> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
