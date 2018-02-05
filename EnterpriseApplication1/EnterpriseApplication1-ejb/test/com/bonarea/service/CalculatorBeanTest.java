/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bonarea.service;

import javax.ejb.embeddable.EJBContainer;
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
public class CalculatorBeanTest {
    
    public CalculatorBeanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of sum method, of class CalculatorBean.
     */
    @Test
    public void testSum() throws Exception {
        System.out.println("sum");
        int num1 = 1;
        int num2 = 2;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CalculatorBean instance = (CalculatorBean)container.getContext().lookup("java:global/classes/CalculatorBean");
        int expResult = 3;
        int result = instance.sum(num1, num2);
        assertEquals(expResult, result);
        container.close();
    }

    /**
     * Test of substract method, of class CalculatorBean.
     */
    @Test
    public void testSubstract() throws Exception {
        System.out.println("substract");
        int num1 = 2;
        int num2 = 2;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CalculatorBean instance = (CalculatorBean)container.getContext().lookup("java:global/classes/CalculatorBean");
        int expResult = 0;
        int result = instance.substract(num1, num2);
        assertEquals(expResult, result);
        container.close();
    }

    /**
     * Test of multiply method, of class CalculatorBean.
     */
    @Test
    public void testMultiply() throws Exception {
        System.out.println("multiply");
        int num1 = 2;
        int num2 = 2;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CalculatorBean instance = (CalculatorBean)container.getContext().lookup("java:global/classes/CalculatorBean");
        int expResult = 4;
        int result = instance.multiply(num1, num2);
        assertEquals(expResult, result);
        container.close();
    }

    /**
     * Test of divide method, of class CalculatorBean.
     */
    @Test
    public void testDivide() throws Exception {
        System.out.println("divide");
        int num1 = 2;
        int num2 = 2;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CalculatorBean instance = (CalculatorBean)container.getContext().lookup("java:global/classes/CalculatorBean");
        int expResult = 1;
        int result = instance.divide(num1, num2);
        assertEquals(expResult, result);
        container.close();
    }
    
}
