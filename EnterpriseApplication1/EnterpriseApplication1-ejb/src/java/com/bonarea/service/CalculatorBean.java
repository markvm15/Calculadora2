/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bonarea.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;


/**
 *
 * @author marcv
 */
@Stateless
@LocalBean
public class CalculatorBean {
    @Inject
    @Named("calculator")
    private ICalculator calculator;
    public int sum(int num1, int num2){
        return calculator.add(num1, num2);
    }
    public int substract(int num1, int num2){
        return calculator.substract(num1, num2);
    }
    public int multiply(int num1, int num2){
        return calculator.multiply(num1, num2);
    }
    public int divide(int num1, int num2){
        return calculator.divide(num1, num2);
    }
}
