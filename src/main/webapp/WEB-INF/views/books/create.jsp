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
    <title>Dodawanie nowej książki</title>
</head>
<body>

<center>
    <form:form modelAttribute="newBook" method="post">
        <div><form:errors path="*" /></div>
        <form:input path="title" placeholder="podaj tytuł"/>
        <form:input path="description" placeholder="podaj opis"/>
        <form:input path="pages" placeholder="Podaj liczbę stron" type = "number" />

        <form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id"/>
        <form:select path="authors" items="${authors}" itemLabel="fullName" itemValue="id"/>

        <input type="submit" value="send"/>
    </form:form>

</center>

</body>
</html>
