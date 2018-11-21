<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tomek
  Date: 21.11.18
  Time: 09:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>errors</title>
</head>
<body>

<center>

    <c:forEach items="${errors}" var="error">
        <h2>BŁĄD WALIDACJI: ${error.getPropertyPath()}</h2>
        <h3>${error.getMessage()}</h3>
        <h3>${error.getInvalidValue()}</h3>
        <br>
    </c:forEach>

</center>

</body>
</html>

<!--
Path path = violation.getPropertyPath();
String message = violation.getMessage();
Object invalidValue = violation.getInvalidValue();-->