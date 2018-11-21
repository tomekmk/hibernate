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
    <title>Wszyscy autyrzy</title>
</head>
<body>

<center>
    <h3><a href="/authors/create/">Dodaj nowego autora</a> </h3>
    <h4><a href="/">powrót</a></h4>
    <h2>Lista wszystkich autorów:</h2>

    <table>
        <thead>
        <tr><th>Id</th>
            <th>imię</th>
            <th>nazwisko</th>
            <th>pesel</th>
            <th>email</th>
            <%--<th>ocena</th>--%>
            <th>opcje</th>
            </tr>
        </thead>

        <tbody>

        <c:forEach items="${authors}" var="author">
            <tr>
                <td>${author.id}</td>
                <td>${author.firstName}</td>
                <td>${author.lastName}</td>
                <td>${author.pesel}</td>
                <td>${author.email}</td>
                <%--<td>--%>

                    <%--<c:forEach items="${book.authors}" var="author">--%>
                        <%--${author.fullName}--%>
                    <%--</c:forEach>--%>

                <%--</td>--%>
                <%--<td>${book.rating}</td>--%>
                <td><a href="/authors/remove/${author.id}">U</a> </td>
                <td><a href="/authors/edit/${author.id}">E</a> </td>
            </tr>
        </c:forEach>

        </tbody>

    </table>

</center>

</body>
</html>
