<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="/WEB-INF/header.jspf"%>
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
	<form action="EditVehicle" method="post">
	<label>Vehicle Id: <input type="text" name="vehicleId" value="<%=request.getParameter("vehicleId") %>" readonly="readonly"></label><br>
	<label>Model:  <input type="text" name="model" ></label><br>
	<label>Marka: <input type="text" name="trademark" ></label><br>
	<label>Rok produkcji: <input type="number" name="produtionYear" min="1900" ></label><br>
	<label>Numer rejestracyjny <input type="text" name="registrationNumber" ></label><br>
	<label>Data przeglądu: <input type="date" name="date"> </label><br>
	<label>Wprowadź id właściciela: <input type="text" name="ownerId"> </label><br>
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
	<form action="EditVehicle" method="post">
	<label>Vehicle Id: <input type="text" name="vehicleId" value="<%=request.getParameter("vehicleId") %>" readonly="readonly"></label><br>
	<label>Model:  <input type="text" name="model" ></label><br>
	<label>Marka: <input type="text" name="trademark" ></label><br>
	<label>Rok produkcji: <input type="number" name="produtionYear" min="1900" ></label><br>
	<label>Numer rejestracyjny <input type="text" name="registrationNumber" ></label><br>
	<label>Data przeglądu: <input type="date" name="date"> </label><br>
	<label>Wprowadź id właściciela: <input type="text" name="ownerId"> </label><br>
	<input type="submit" value="Edit">

	</form>
	<%
	} %>



</body>
<%@ include file="/WEB-INF/footer.jspf"%>
</html>