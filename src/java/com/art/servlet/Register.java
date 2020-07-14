/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.art.servlet;
import java.util.Random;
import com.art.dao.UserDao;
import com.art.db.*;
import com.art.dto.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
public class Register extends HttpServlet {

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
PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String email_id = request.getParameter("email_id");
		String password = request.getParameter("password");
		String mobile_number = request.getParameter("mobile_number");
		String dob = request.getParameter("dob");
		String state = request.getParameter("state");
		String gender = request.getParameter("gender");
                
                String OTPCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
                StringBuilder otpp = new StringBuilder();
                Random rnd = new Random();
                while (otpp.length() < 6) { // length of the random string.
                    int index = (int) (rnd.nextFloat() * OTPCHARS.length());
                    otpp.append(OTPCHARS.charAt(index));
                }
                String otp = otpp.toString();
                
              User user=new User();
              user.setFirstname(first_name);
              user.setLastname(last_name);
              user.setEmail(email_id);
              user.setGender(gender);
              user.setMobile(mobile_number);
              user.setDob(dob);
              user.setPassword(password);
              user.setState(state);
              user.setOtp(otp);
              boolean addUser = UserDao.addUser(user);
              
              
               String a=SendSmsNew.sendotp(mobile_number,first_name,last_name,otp);
        System.out.println("------------"+a);
        
                 response.sendRedirect("otp.jsp");
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
