/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bonarea.calculadora.servlet;

import com.bonarea.calculadora.interfaces.CalculadoraI;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marcv
 */
public class CalculadoraServlet extends HttpServlet {

    @Inject
    @Named("calculadoraService")
    private CalculadoraI calculadoraI;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            int num1 = Integer.parseInt(request.getParameter("num1"));
            int num2 = Integer.parseInt(request.getParameter("num2"));
            int resultat;
            boolean incorecte = false;
            switch(request.getParameter("operation")){
                case "suma":
                    resultat= calculadoraI.add(num1, num2);
                    break;
                case "resta":
                    resultat=calculadoraI.substract(num1, num2);
                    break;
                case "multiplicacio":
                    resultat=calculadoraI.multiply(num1, num2);
                    break;
                case "divisio":
                    resultat=calculadoraI.divide(num1, num2);
                    break;
                default: 
                    incorecte=true;
                    resultat = 0;
                break;
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CalculadoraServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CalculadoraServlet at " + request.getContextPath() + "</h1>");
            if(!incorecte){
                out.println("<h2>El resultat és: " + resultat + "</h2>");
            }else out.println("<h2>La operacio es incorrecta</h2>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
