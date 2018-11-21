<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tomek
  Date: 20.11.18
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wszystkie książki</title>
</head>
<body>

<center>
    <h3><a href="/books/create/">Dodaj nową książkę</a> </h3>
    <h4><a href="/">powrót</a></h4>
<h2>Lista wszystkich książek:</h2>

    <table>
        <thead>
        <tr><th>Id</th>
        <th>tytuł</th>
        <th>opis</th>
        <th>wydawca</th>
        <th>autorzy</th>
        <th>ocena</th>
        <th>opcje</th></tr>
        </thead>

        <tbody>

        <c:forEach items="${allBooks}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.description}</td>
                <td>${book.publisher.name}</td>
                <td>

                    <c:forEach items="${book.authors}" var="author">
                        ${author.fullName}
                    </c:forEach>

                </td>
                <td>${book.rating}</td>
                <td><a href="/books/remove/${book.id}">U</a> </td>
                <td><a href="/books/edit/${book.id}">E</a> </td>
            </tr>
        </c:forEach>

        </tbody>

    </table>

</center>

</body>
</html>
