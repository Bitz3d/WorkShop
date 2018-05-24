<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8" import="pl.RafalWorkshop.Employee, java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>

<style>

table, td, th, tr {

    border: 1px solid black;

    border-collapse: collapse;

}

th {

    background-color: #ccc;

}

</style>

</head>

<body>
	<form action="SearchResult" method="post">

		<label>Wprowadz nawisko do wyszukania: <input type="text"
			name="search"></label> <input type="submit" value="Search">
	</form>
	<table>

    <tr>

        <th>Id</th>

        <th>Imię</th>

        <th>Nazwisko</th>
        <th>Numer Telefonu</th>
        <th>Notka</th>
        <th>Zarobki na godzine</th>

    </tr>

    <%

    List<Employee> employees = (List<Employee>) request.getAttribute("employee");

    for (Employee employee : employees) {

    %>

    <tr>

        <td><%= employee.getId() %></td>
        <td><%= employee.getName() %></td>
        <td><%= employee.getLastName() %></td>
        <td><%= employee.getTelephoneNumber() %></td>
        <td><%= employee.getNote() %></td>
        <td><%= employee.getPricePerHour() %></td>
        <td><a href="EditEmployee.jsp?employeeId=<%= employee.getId()%>"><input type='submit' value='Edit Employee'></a></td>
        <td><a href="DeleteEmployee?employeeId=<%= employee.getId()%>"><input type='submit' value='Delete Employee'></a></td>


    </tr>

    <%

    }

    %>

</table>

<a href="AddEmployee.jsp"><input type='submit' value='AddEmployee'></a>

</body>

</html>