<%-- 
    Document   : registration
    Created on : Jul 12, 2020, 8:23:57 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>  
<body>  
<form action="register" method="POST" enctype="multipart/form-data">  
   <label for="img">Select image:</label>
  <input type="file" id="img" name="img"><br/><br/>
FirstName:<input type="text" name="first_name"/><br/><br/>

<input type="submit" value="submit"/>  
  
</form>  
</body>  
</html> 