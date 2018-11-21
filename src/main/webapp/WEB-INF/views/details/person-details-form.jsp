<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<center>
    <form:form modelAttribute="newPersonDTO" method="post">
        <div>Login: <form:input path="login" placeholder="Podaj login"/></div>
        <div>Password: <form:input path="password" placeholder="Podaj hasło"/></div>
        <div>Email: <form:input path="email" placeholder="Podaj email"/></div>
        <div>Imię: <form:input path="firstName" placeholder="Podaj imię"/></div>
        <div>Nazwisko: <form:input path="lastName" placeholder="Podaj nazwisko"/></div>

        <hr>

        <div>Płeć: <form:radiobuttons path="gender" items="${gender}"/></div>
        <div>Kraj: <form:select path="country" items="${country}"/></div>
        <div>Notatka:<br><form:textarea path="notes"/></div>
        <div>Lista mailingowa: <form:checkbox path="mailingList"/></div>
        <div>Umiejętności:<br><form:select items="${programmingSkills}" path="programmingSkills" multiple="true"/></div>
        <div>Hobby: <form:checkboxes path="hobbies" items="${qwerty}"/></div>
        <div><input type="submit" value="wyslij"></div>
    </form:form>
</center>

</body>
</html>