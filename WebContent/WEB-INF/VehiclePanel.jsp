<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8" import="pl.RafalWorkshop.Vehicle, java.util.List"%>

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

<table>

    <tr>

        <th>Id</th>

        <th>Model</th>

        <th>Marka</th>
        <th>Rok produkcji</th>
        <th>Numer Rejestracyjny</th>
        <th>Przegląd techniczny</th>
        <th>Id właściciela</th>

    </tr>

    <%

    List<Vehicle> vehicles = (List<Vehicle>) request.getAttribute("vehicles");

    for (Vehicle vehicle : vehicles) {

    %>

    <tr>

        <td><%= vehicle.getId() %></td>
        <td><%= vehicle.getModel() %></td>
        <td><%= vehicle.getTrademark() %></td>
        <td><%= vehicle.getProdutionear()%></td>
        <td><%= vehicle.getRegistrationNumber()%></td>
        <td><%= vehicle.getTechnicalReview()%></td>
        <td><%= vehicle.getCustomerID()%></td>
        <td><a href="EditVehicle.jsp?vehicleId=<%= vehicle.getId()%>"><input type='submit' value='Edit Vehicle'></a></td>
        <td><a href="DeleteVehicle?vehicleId=<%= vehicle.getId()%>"><input type='submit' value='Delete Vehicle'></a></td>


    </tr>

    <%

    }

    %>

</table>

<a href="addVehicle.jsp"><input type='submit' value='Add Vehicle'></a>
</body>

</html>