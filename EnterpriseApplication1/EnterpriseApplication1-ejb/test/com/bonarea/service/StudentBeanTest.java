/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bonarea.service;

import com.bonarea.model.Student;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marcv
 */
public class StudentBeanTest {
    
    static EJBContainer container = null;
    static StudentBeanLocal instance = null;
    @BeforeClass
    public static void setUpClass(){
        
        Map<String, Object> properties = new HashMap<String, Object>();
            properties.put("org.glassfish.ejb.embedded.glassfish.configuration.file", "domain_universe.xml");
        container = javax.ejb.embeddable.EJBContainer.createEJBContainer(properties);
        try {
            instance = (StudentBeanLocal)container.getContext().lookup("java:global/classes/StudentBean");
        } catch (NamingException ex) {
            Logger.getLogger(StudentBeanTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public StudentBeanTest() {
    }
    
    @AfterClass
    public static void tearDownClass() {
        container.close();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class StudentBean.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        Student model = new Student();
        model.setName("Marc");
        model.setSurname("Vives");
        model.setCard_id("aabbcc");

        int expResult = 1;
        int result = instance.add(model);
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class StudentBean.
     */
//    @Test
//    public void testDelete() throws Exception {
//        System.out.println("delete");
//        Student model = new Student();
//        model.setName("Marc2");
//        model.setSurname("Vives");
//        model.setCard_id("23412");
//        instance.add(model);
//        int expResult = 1;
//        int result = instance.delete(model);
//        assertEquals(expResult, result);
//    }

    /**
     * Test of update method, of class StudentBean.
     */
//    @Test
//    public void testUpdate() throws Exception {
//        System.out.println("update");
//        Student model = new Student();
//        model.setName("Marc2");
//        model.setSurname("Vives");
//        model.setCard_id("23412");
//        instance.add(model);
//        int expResult = 1;
//        model.setCard_id("103u76712");
//        int result = instance.update(model);
//        assertEquals(expResult, result);
//    }

    /**
     * Test of getAll method, of class StudentBean.
     */
//    @Test
//    public void testGetAll() throws Exception {
//        System.out.println("getAll");
//
//        Student model = new Student();
//        model.setName("Marc");
//        model.setSurname("Vives");
//        model.setCard_id("aabbcc");
//        int afectades = instance.add(model);
//        assertEquals(afectades, 1);
//        List result = instance.getAll();
//        assertTrue(result.size()>0);
//    }
    
}
