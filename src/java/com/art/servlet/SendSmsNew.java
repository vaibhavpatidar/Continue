/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.art.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author ind
 */
class SendSmsNew {
       public static String sendotp(String mobilenumber,String firstname,String lastname,String otp){
                        //Your authentication key
            //String authkey = "269810AKXf2a6Cuv8d5e50f710P1";
            String authkey = "269810AYLieKp8MG5c9cda01";
            //Multiple mobiles numbers separated by comma
            String mobiles = mobilenumber;
            //Sender ID,While using route4 sender id should be 6 characters long.
            String senderId = "Cartse";
            //Your message to send, Add URL encoding here.
          //define route
            //Transactional route="4"
            //Promotonal route="1"
            //OTP route="OTP" 
            String route="4";

            //Prepare Url
            URLConnection myURLConnection=null;
            URL myURL=null;
            BufferedReader reader=null;
          
            //encoding message
            //Send SMS API
            
             String message = "Hi "+firstname+" "+lastname+" your one time password otp is  "+otp;
           
             
            String mainUrl="https://2factor.in/API/V1/7bb4fa9d-c503-11ea-9fa5-0200cd936042/SMS/"+mobiles+"/"+otp;
             try
            {
                //prepare connection
                myURL = new URL(mainUrl);
                myURLConnection = myURL.openConnection();
                myURLConnection.connect();
                reader= new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
                //reading response
                String response;
                while ((response = reader.readLine()) != null)
                //print response
                System.out.println(response);

                //finally close connection
                reader.close();
            }
            catch (IOException e)
            {
                    e.printStackTrace();
            }

            return otp;
        }
}
