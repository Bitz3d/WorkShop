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
	<form action="EditOrder" method="post">
		<label>vehicle Id: <input type="text" name="orderId" value="<%=request.getParameter("orderId") %>" readonly="readonly"></label><br>
		<label>Planowany start pracy: <input type="date" name="planingStartOfWork"></label><br>
		<label>Start pracy: <input type="date" name="start_of_work"></label><br>
		<label>Id pracownika: <input type="number" name="employeeId" min="1"></label><br>
		<label>Opis problemu: <input type="text" name="problemDescription"></label><br>
		<label>Opis po naprawie: <input type="text" name="afterFixDescription"></label><br>
		<label>Status naprawy: 
		<select name="status">
    		<option value="przyjety" >Przyjęty</option>
    		<option value="zatwierdzonekoszty"  >Zatwierdzone koszty naprawy</option>
    		<option value="wnaprawie">W naprawie</option>
    		<option value="gotowydoodbioru" >Gotowy do odbioru</option>
    		<option value="rezygnacja" >Rezygnacja</option>
		</select>
		</label>
		<br>
		<label>Id samochodu: <input type="number" name="vehicleId" min="1"></label><br>
		<label>Koszt części: <input type="number" name="partsCost" min="0.1"></label><br>
		<label>Podaj liczbę godzin : <input type="number" name="laborHouresToFix" min="1"></label><br>

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
	<form action="EditOrder" method="post">
		<label>vehicle Id: <input type="text" name="orderId" value="<%=request.getParameter("orderId") %>" readonly="readonly"></label><br>
		<label>Planowany start pracy: <input type="date" name="planingStartOfWork"></label><br>
		<label>Start pracy: <input type="date" name="start_of_work"></label><br>
		<label>Id pracownika: <input type="number" name="employeeId" min="1"></label><br>
		<label>Opis problemu: <input type="text" name="problemDescription"></label><br>
		<label>Opis po naprawie: <input type="text" name="afterFixDescription"></label><br>
		<label>Status naprawy: 
		<select name="status">
    		<option value="przyjety" >Przyjęty</option>
    		<option value="zatwierdzonekoszty"  >Zatwierdzone koszty naprawy</option>
    		<option value="wnaprawie">W naprawie</option>
    		<option value="gotowydoodbioru" >Gotowy do odbioru</option>
    		<option value="rezygnacja" >Rezygnacja</option>
		</select>
		</label>
		<br>
		<label>Id samochodu: <input type="number" name="vehicleId" min="1"></label><br>
		<label>Koszt części: <input type="number" name="partsCost" min="0.1"></label><br>
		<label>Podaj liczbę godzin : <input type="number" name="laborHouresToFix" min="1"></label><br>

		<input type="submit" value="Edit">
	</form>
	<%
	} %>

</body>
</html>

