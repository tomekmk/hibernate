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
    <title>Edycja autora</title>
</head>
<body>

<center>
    <form:form modelAttribute="editingAuthor" method="post">
        <form:errors path="*"/><br>
        <form:input path="firstName"/>
        <form:input path="lastName"/>
        <form:input path="pesel"/>
        <form:input path="email"/>
        <form:input path="yearOfBirth"/>

        <%--<form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id"/>--%>
        <%--<form:select path="authors" items="${authors}" itemLabel="fullName" itemValue="id"/>--%>

        <input type="submit" value="send"/>
    </form:form>

</center>

</body>
</html>
