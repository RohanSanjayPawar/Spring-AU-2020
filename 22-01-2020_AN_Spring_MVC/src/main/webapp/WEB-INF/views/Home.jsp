<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Data</title>
        
    </head>
    <body>
        <div align="center">
            <h1>Employee List</h1>
            <h3><a href="/SpringJDBC/newEmployee">New Employee</a></h3>
            <table border="1">
            	<thead>
	                <th>Emp ID</th>
	                <th>First Name</th>
	                <th>Last Name</th>
	                <th>Designation</th>
	                <th>Department</th>
	                <th>Action</th>
                </thead>
                 
                <c:forEach var="emp" items="${employees}"  varStatus="status">
	                <tr>
	                    <td>${status.index+1}</td>
	                    <td>${emp.firstName}</td>
	                    <td>${emp.lastName}</td>
	                    <td>${emp.designation}</td>
	                    <td>${emp.department}</td>
	                    <td>
	                        <a href="/SpringJDBC/editEmployee?id=${emp.id}">Edit</a>
	                        &nbsp;&nbsp;&nbsp;&nbsp;
	                        <a href="/SpringJDBC/deleteEmployee?id=${emp.id}">Delete</a>
	                    </td>
	                             
	                </tr>
                </c:forEach>             
            </table>
        </div>
    </body>
</html>