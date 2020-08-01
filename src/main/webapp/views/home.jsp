<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Surya soft</title>
<link rel="icon" type="image/png" href="images/lg.png"/> 
<style>
header {
  background-color: #581845;
  padding: 20px;
  text-align: center;
  font-size: 25px;
  color: white;
}
nav {
  float: left;
  width: 60%;
  height: 300px;
  background: #ccc;
  padding: 20px;
}
section:after {
  content: "";
  display: table;
  clear: both;
}

footer {
  background-color: #581845;
  padding: 10px;
  text-align: center;
  color: white;
}
div.relative {
  position: relative;
  left: 120px;
  
}

</style>
</head>
<body>
<header>
<h2>SuryaSoft solutions pvt.ltd</h2>
</header>
<section>
<nav>
<p>image1</p>
<p>image2</p>
<p>image3</p>
</nav>
<form:form action="/login" modelAttribute="login"  method="POST">
	
	<table align="center">
		<tr>
			<td><h2 style="align:center"><u>Login here</u></h2></td>
		</tr>
		
		<tr>
		<td><h3 style="color:red">${er}</h3></td>
		</tr>
		
		<tr>
			<td>Email: </td>
			<td><form:input path="email"/></td>
		</tr>
		<tr>
			<td>Password: </td>
			<td><form:password path="password"/></td>
		</tr>
		<tr>
		<td></td>
		<td><input type="submit" value="Sign in"></td>
		</tr>
	</table>
	
</form:form>
<br/>
<div class="relative"><a href="/signup">Sign Up</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/forgot">Forgot Password</a></div>
</section>
<footer>
  <p>Footer</p>
</footer>
</body>
</html>