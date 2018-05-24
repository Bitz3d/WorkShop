<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%  Cookie[] cookie = request.getCookies(); 
 	 boolean przelacznik = false;
 	for(Cookie cookieToCheck : cookie)
 	{
 		
 		if(cookieToCheck.getName().equals("myCookie"))
 		{
 			przelacznik=true;
 			%>

	<p>Wprowadzone dane są nieprawidłe</p>
	<form action="EditCustomer" method="post">
		<label>Customer Id: <input type="text" name="customerId" value="<%=request.getParameter("customerId") %>" readonly="readonly"></label><br>
		<label>First name: <input type="text" name="name"></label><br>
		<label>Last name: <input type="text" name="lastname"></label><br>
		<label>Date of Birth: <input type="date" name="date"></label><br>
		<input type="submit" value="Edit">
	</form>
	<% cookieToCheck.setMaxAge(0);
 				response.addCookie(cookieToCheck);
 				

 		}

 	}

 %>
	<% if(!przelacznik)
	{
		%>
	<form action="EditCustomer" method="post">
		<label>Customer Id: <input type="text" name="customerId" value="<%=request.getParameter("customerId") %>" readonly="readonly"></label><br>
		<label>First name: <input type="text" name="name"></label><br>
		<label>Last name: <input type="text" name="lastname"></label><br>
		<label>Date of Birth: <input type="date" name="date"></label><br>
		<input type="submit" value="Edit">
	</form>
	<%
	} %>



</body>
</html>