<%@taglib uri="http://java.sun.com/jsp/jstl/core"
        prefix="c" %>

<html>
    <body>
        <p>USERS</p>

        <table>
            <thead><td>Login</td><td>Name</td></thead>
            <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.login}</td>
                <td>${user.name}</td>
            </tr>
            </c:forEach>
        </table>

        <a href="/ProfItSoft-lec-07-08/home">Home</a>
    </body>
</html>