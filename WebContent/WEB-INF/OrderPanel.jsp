<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8" import="pl.RafalWorkshop.Order, java.util.List"%>

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

        <th>Data zamowienia</th>
        
        <th>Planowany start naprawy</th>
        <th>Start naprawy</th>
        <th>Id pracownika</th>
        <th>Opis problemu</th>
        <th>Opis po naprawie</th>
        <th>Status</th>
        <th>Id samochodu</th>
        <th>Koszt całkowity</th>
		<th>Koszt części</th>
		<th>Roboczogodziny</th>



    </tr>

    <%

    List<Order> orders = (List<Order>) request.getAttribute("orders");

    for (Order order : orders) {

    %>

    <tr>

		<td><%= order.getId() %></td>
        <td><%= order.getOrderDate() %></td>
        <td><%= order.getPlannigWorkingDate() %></td>
		<td><%= order.getStartOfWork() %></td>
		<td><%= order.getEmployeeID() %></td>
		<td><%= order.getProblemDescription() %></td>
		<td><%= order.getAfterFixDescription() %></td>
		<td><%= order.getStatus() %></td>
		<td><%= order.getVehicleID() %></td>
		<td><%= order.getTotalCost() %></td>
		<td><%= order.getPartsCost() %></td>
		<td><%= order.getLaborHouresToFix() %></td>
		

        <td><a href="EditOrder.jsp?orderId=<%= order.getId()%>"><input type='submit' value='Edit Order'></a></td>
        <td><a href="DeleteOrder?orderId=<%= order.getId()%>"><input type='submit' value='Delete Order'></a></td>


    </tr>

    <%

    }

    %>

</table>

<a href="AddOrder.jsp"><input type='submit' value='Add Order'></a>
</body>

</html>