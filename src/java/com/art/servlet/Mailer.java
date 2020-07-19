
package com.art.servlet;
import java.util.Properties;    
import java.util.Random;
import javax.mail.*;    
import javax.mail.internet.*;  


 import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;


   public class Mailer{  
        public static void send(String to,String sub,String msg){  
              //Get properties object    
              Properties props = new Properties();    
              props.put("mail.smtp.host", "smtp.gmail.com");    
              props.put("mail.smtp.socketFactory.port", "465");    
              props.put("mail.smtp.socketFactory.class",    
                        "javax.net.ssl.SSLSocketFactory"); 
              props.put("mail.smtp.starttls.enable", "true");
              props.put("mail.smtp.auth", "true");    
              props.put("mail.smtp.port", "465");    
              //get Session   
           
Session session = Session.getInstance(props, new javax.mail.Authenticator() {
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("artnexussofficial@gmail.com", "art@ssvv");
    }
});
              //compose message    
              try {    
               MimeMessage message = new MimeMessage(session);   
               message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
               message.setSubject(sub);    
               message.setContent(msg, "text/html");
               //message.setText(msg);          send text message only    
               //send message  
               System.out.println("---------------------------new line---------");
               Transport.send(message);    
               System.out.println("message sent successfully");    
              }
              catch (MessagingException e) {
                  throw new RuntimeException(e);
              }       
        }  
      
    }    