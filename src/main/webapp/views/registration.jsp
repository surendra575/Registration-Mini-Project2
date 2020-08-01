<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
</script>
<script src="./js/app.js"></script>
</head>
<body>
<h2>Registration</h2>
<form:form action="/addUser" modelAttribute="user" method="POST">
<table>
	<tr>
		<td>First Name: </td>
		<td><form:input path="firstName"/></td>
	</tr>
	<tr>
		<td>Last Name: </td>
		<td><form:input path="lastName"/></td>
	</tr>
	<tr>
		<td>Email: </td>
		<td><form:input path="email"/>
		<font color='red'>
						<div id="dupEmail"></div>
					</font>	
		<font color='green'>
						<div id="uniqueEmail"></div>
					</font>	
		</td>
		
	</tr>
	<tr>
		<td>Phno: </td>
		<td><form:input path="phno"/></td>
	</tr>
	<tr>
		<td>DOB: </td>
		<td><form:input type="date" path="dob"/></td>
	</tr>
	<tr>
	<td>Gender: </td>
	<td><form:radiobutton path="gender" value="male"/>Male
	<form:radiobutton path="gender" value="female"/>Fe-male</td>
	</tr>
	
	<tr>
		<td>Country:  </td>
		<td><form:select path="country">
			<form:option value="">-Select-</form:option>
			<form:options items="${countries}"/>
			</form:select>	
		</td>
	</tr>
	<tr>
		<td>State:  </td>
		<td><form:select path="state">
			<form:option value="">-Select-</form:option>
			</form:select>	
		</td>
	</tr>
	<tr>
		<td>City:  </td>
		<td><form:select path="city">
			<form:option value="">-Select-</form:option>
			</form:select>	
		</td>
	</tr>
	<tr>
	<td><input type="reset" value="Reset"></td>
	<td><input type="submit" value="Submit">
	</tr>
	
	
</table>
</form:form>
</body>
</html>