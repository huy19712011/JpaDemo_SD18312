<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Students</h2>

<table border="1">
    <tr>
        <th>#</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th colspan="2">Action</th>
    </tr>
    <c:forEach var="tempStudent" items="${students}" varStatus="i">
        <tr>
            <td>${i.index + 1}</td>
            <td>${tempStudent.firstName}</td>
            <td>${tempStudent.lastName}</td>
            <td>${tempStudent.email}</td>
            <td>
                <form method="post">
                    <a href="">Update</a>
                    |
                    <a href="">Delete</a>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
