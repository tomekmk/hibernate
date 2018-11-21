<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tomek
  Date: 21.11.18
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>propozycje</title>
</head>
<body>


<center>
    <h3><a href="/propositions/create/">Dodaj nową książkę</a> </h3>
    <h4><a href="/">powrót</a></h4>
    <h2>Lista książek proponowanych:</h2>

    <table>
        <thead>
        <tr><th>Id</th>
            <th>tytuł</th>
            <th>opis</th>
            <th>opcje</th></tr>
        </thead>

        <tbody>

        <c:forEach items="${propBooks}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.description}</td>
                <td>${book.rating}</td>
                <td><a href="/propositions/remove/${book.id}">U</a>
                <a href="/propositions/edit/${book.id}">E</a> </td>
            </tr>
        </c:forEach>

        </tbody>

    </table>

</center>
</body>
</html>
