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
    <title>Wszyscy wydawcy</title>
</head>
<body>

<center>
    <h3><a href="/publishers/create/">Dodaj nowego wydawcę</a> </h3>
    <h4><a href="/">powrót</a></h4>
    <h2>Lista wszystkich wydawców:</h2>

    <table>
        <thead>
        <tr><th>Id</th>
            <th>nazwa</th>
            <th>nip</th>
            <th>regon</th>
            <%--<th>autorzy</th>--%>
            <%--<th>ocena</th>--%>
            <th>opcje</th>
            </tr>
        </thead>

        <tbody>

        <c:forEach items="${publishers}" var="publisher">
            <tr>
                <td>${publisher.id}</td>
                <td>${publisher.name}</td>
                <td>${publisher.nip}</td>
                <td>${publisher.regon}</td>
                <%--<td>${book.publisher.name}</td>--%>
                <%--<td>--%>

                    <%--<c:forEach items="${book.authors}" var="author">--%>
                        <%--${author.fullName}--%>
                    <%--</c:forEach>--%>

                <%--</td>--%>
                <%--<td>${book.rating}</td>--%>
                <td><a href="/publishers/remove/${publisher.id}">U</a> </td>
                <td><a href="/publishers/edit/${publisher.id}">E</a> </td>
            </tr>
        </c:forEach>

        </tbody>

    </table>

</center>

</body>
</html>
