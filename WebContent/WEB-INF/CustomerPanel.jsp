<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8" import="pl.RafalWorkshop.Customer, java.util.List"%>

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

        <th>Imię</th>

        <th>Nazwisko</th>
        <th>Data urodzenia</th>


    </tr>

    <%

    List<Customer> customers = (List<Customer>) request.getAttribute("customers");

    for (Customer customer : customers) {

    %>

    <tr>

        <td><%= customer.getId() %></td>
        <td><%= customer.getName() %></td>
        <td><%= customer.getLasyName() %></td>
        <td><%= customer.getDateOfBirth() %></td>

        <td><a href="EditCustomer.jsp?customerId=<%= customer.getId()%>"><input type='submit' value='Edit Customer'></a></td>
        <td><a href="DeleteCustomer?customerId=<%= customer.getId()%>"><input type='submit' value='Delete Customer'></a></td>


    </tr>

    <%

    }

    %>

</table>

<a href="AddCustomer.jsp"><input type='submit' value='AddCustomer'></a>
</body>

</html>