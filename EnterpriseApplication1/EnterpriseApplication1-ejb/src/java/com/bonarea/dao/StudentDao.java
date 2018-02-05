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
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.sql.DataSource;

/**
 *
 * @author marcv
 */
@RequestScoped
@MySqlDao
public class StudentDao implements IDAO<Student>{
    @Resource(name="jdbc/mySqlResource")
    private DataSource dataSource;

    public StudentDao(){
        
    }
    
    @Override
    public int add(Student model) throws SQLException {
        int files;
        try (Connection con = dataSource.getConnection()) {
            String query = "Insert into students (name,surname,card_id) values (?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            //ps.setInt(1, model.getStudent_id());
            ps.setString(1, model.getName());
            ps.setString(2, model.getSurname());
            ps.setString(3, model.getCard_id());
            files = ps.executeUpdate();
            con.close();
        }
        return files;
    }
    @Override
    public int delete(Student model) throws SQLException {
        int afectades;
        try (Connection con = dataSource.getConnection()) {
            String query = "Delete from students where name=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, model.getName());
            afectades = ps.executeUpdate();
            con.close();
        }
        return afectades;
    }

    @Override
    public int update(Student model) throws SQLException {
         int files;
        try (Connection con = dataSource.getConnection()) {
            String query = "Update students set surname=?, card_id=? where name=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(4, model.getName());
            ps.setString(1, model.getName());
            ps.setString(2, model.getSurname());
            ps.setString(3, model.getCard_id());
            files = ps.executeUpdate();
            con.close();
        }
        return files;
    }

    @Override
    public List<Student> getAll() throws SQLException {
        List<Student> llista=new ArrayList<>();
        try(Connection con = dataSource.getConnection()) {
            String query = "Select * from students";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Student s = new Student();
                s.setStudent_id(rs.getInt("student_id"));
                s.setName(rs.getString("name"));
                s.setSurname(rs.getString("surname"));
                s.setCard_id(rs.getString("card_id"));
                llista.add(s);
            }
            con.close();
        }
        return llista;
    }
    
    
    
    
}
