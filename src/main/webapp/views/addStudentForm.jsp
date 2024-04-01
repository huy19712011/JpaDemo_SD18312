<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Student</title>
</head>
<body>
<h3>Add Student</h3>

<%--<form action="../Students" method="POST">--%>
<form action="${pageContext.request.contextPath}/Students/insert" method="POST">
    <input type="hidden" name="command" value="ADD"/>

    <table>
        <tbody>
        <tr>
            <td><label>First name:</label></td>
            <td><input type="text" name="firstName"/></td>
        </tr>
        <tr>
            <td><label>Last name:</label></td>
            <td><input type="text" name="lastName"/></td>
        </tr>
        <tr>
            <td><label>Email:</label></td>
            <td><input type="text" name="email"/></td>
        </tr>
        <tr>
            <td><label></label></td>
            <td>
                <input type="submit" value="Save" class="save"/>

            </td>
        </tr>
        </tbody>
    </table>

</form>
</body>
</html>
