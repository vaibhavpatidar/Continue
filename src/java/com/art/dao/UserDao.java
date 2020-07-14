/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.art.dao;

import com.art.dto.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;



import com.art.db.DBConnection;
import com.art.db.DBProperties;


/**
 *
 * @author hp
 */
public class UserDao {
    
public static boolean addUser(User user)
{
    String first_name =user.getFirstname();
    String last_name = user.getLastname();
    String email_id = user.getEmail();
    String password = user.getPassword();
    String mobile_number =user.getMobile();
    String dob =user.getDob();
    String state = user.getState();
    String gender =user.getGender();
    String otp =user.getOtp();
    boolean flag=true;
    try {
                
		Connection con = DBConnection.getConnection();
                 String sql = "INSERT INTO registration (first_name, last_name, mobile_number, email_id, dob, password, gender, state, otp) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, first_name);
		ps.setString(2, last_name);
		ps.setString(3, mobile_number);
		ps.setString(4, email_id);
		ps.setString(5, dob);
		ps.setString(6, password);
		ps.setString(7, gender);
                ps.setString(8, state);
                ps.setString(9, otp);
		flag=ps.execute();
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return flag;
    }


    public static int login_check(String email_id, String password) {
      Connection conn = DBConnection.getConnection();
      System.out.println(password);
      System.out.println(email_id);
        int id=0;
        try {
            String sql = "select id from registration where email_id ='"+email_id+"' and password ='"+password+"'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            System.out.println(sql);
            while (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
}
