<%-- 
    Document   : dashboard
    Created on : 19 Jul, 2020, 12:53:52 AM
    Author     : ind
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.art.dto.User"%>
<%@page import="com.art.dao.UserDao"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
          if (session.getAttribute("id") != null) {
                    System.out.println("session");
                    
                    String id = session.getAttribute("id").toString();
                        int idd = Integer.parseInt(id);
                System.out.println(idd);
        %>
        
        <h1>Hello World!</h1>
        <h1><%=idd%></h1>
        <br>  <br>  <br>  <br>  <br>  <br>
         <form action="like" method="post">  
       <input type="text" name="idd" value="<%=idd%>" >
                 
<input type="submit" value="submit"/>  
        </form>
        
        
        
      
        <%
        } else {
                        System.out.println("no session");
                        response.sendRedirect("loginoffer.jsp");

                    }
        
        %>
    </body>
</html>
