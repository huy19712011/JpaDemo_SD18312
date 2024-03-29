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
                <input type="hidden" name="studentId" value="${tempStudent.id}">
                <input type="hidden" name="command" value="LOAD">
                <button type="submit">Update</button>
                </form>
                <form method="post" style="display: inline;">
                    <input type="hidden" name="studentId" value="${tempStudent.id}">
                    <input type="hidden" name="command" value="DELETE">
                    <button type="submit" onclick="if (!(confirm('Are you sure?'))) return false">Delete</button>
                </form>

            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
