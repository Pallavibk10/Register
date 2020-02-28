<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Submit the form</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

</head>

</head>
<body>

<nav class="navbar navbar-expand-sm navbar-primary bg-dark">
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="signin.jsp">X-workz</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="signup.jsp">signup</a>
    </li>
  </ul>
        
</nav>
<form action="signin.do" method="post">
    
    <div class="col-sm-6">
    <div class="form-group">
    <label for="forsite">Email</label>
    <input type="email" class="form-control" name="email" placeholder="enter the EmailId">
    </div>
    </div>
    
    <div class="col-sm-6">
    <div class="form-group">
    <label for="forsite">Password</label>
    <input type="password" class="form-control" name="password" placeholder="Enter the Passsword">
    </div>
    </div>
     <button type="submit" value="login">login</button>
         </form> 
         <div align="center">

<span style="color:red">${failureMessage}</span>

</div>
    

</body>
</html>