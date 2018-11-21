<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rejestracja nowej osoby ze spring form</title>
</head>
<body>
    <form:form method="post" modelAttribute="newSpringPerson">
        <div>Login: <form:input path="login" placeholder="Podaj login"/></div>
        <div>Email: <form:input path="email" placeholder="Podaj email"/></div>
        <div>Password: <form:input path="password" placeholder="Podaj hasło"/></div>
        <div><input type="submit" value="wyślij"></div>
    </form:form>
</body>
</html>
