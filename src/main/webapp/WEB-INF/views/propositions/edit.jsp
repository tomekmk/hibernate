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
    <title>Edycja propozycji</title>
</head>
<body>

<center>
    <form:form modelAttribute="editingBook" method="post">
        <div><form:errors path="*" /></div>
        <form:input path="title"/>
        <form:input path="description"/>
        <input type="hidden" name="proposition" value="true">

        <input type="submit" value="send"/>
    </form:form>

</center>

</body>
</html>
