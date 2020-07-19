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
LastName:<input type="text" name="last_name"/><br/><br/>
Password:<input type="password" name="password"/><br/><br/>  
Email Id:<input type="text" name="email_id"/><br/><br/>
mobile:<input type="text" name="mobile_number"/><br/><br/>
gender:<input type="text" name="gender"/><br/><br/>
state:<input type="text" name="state"/><br/><br/>
dob:<input type="date" name="dob"/><br/><br/>

<input type="submit" value="submit"/>  
  



<div id="fb-root"></div>
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_GB/sdk.js#xfbml=1&version=v7.0" nonce="DbRQ2I09"></script>
<div class="fb-comments" data-href="http://localhost:8084/Win/registration.jsp" data-numposts="5" data-width=""></div>
</form>  
</body>  
</html> 