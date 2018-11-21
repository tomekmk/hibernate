<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: tomek
  Date: 20.11.18
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodawanie nowego autora</title>
</head>
<body>

<center>
    <form:form modelAttribute="newAuthor" method="post">
        <form:errors path="*"/><br>
        <form:input path="firstName" placeholder="podaj imię"/>
        <form:input path="lastName" placeholder="podaj nazwisko"/>
        <form:input path="pesel" placeholder="podaj pesel"/>
        <form:input path="email" placeholder="podaj email"/>
        <form:input path="yearOfBirth" placeholder="podaj rok urodzenia"/>

        <%--<form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id"/>--%>
        <%--<form:select path="authors" items="${authors}" itemLabel="fullName" itemValue="id"/>--%>

        <input type="submit" value="send"/>
    </form:form>

</center>

</body>
</html>
