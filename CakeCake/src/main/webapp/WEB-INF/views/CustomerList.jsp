<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title></title>
</head>
<body>
<jsp:include page="user/header.jsp"/>
<h1>The customer list</h1>
<table border="1" cellspacing="0" cellpadding="0">
    <thead>
    <td width="213" valign="top"><p><strong>no.</strong></p></td>
    <td width="213" valign="top"><p><strong>name</strong></p></td>
    <td width="213" valign="top"><p><strong>surname</strong></p></td>
    <td width="213" valign="top"><p><strong>username</strong></p></td>
    <td width="213" valign="top"><p><strong>password</strong></p></td>
    <td width="213" valign="top"><p><strong>address</strong></p></td>
    <td width="213" valign="top"><p><strong>image</strong></p></td>
    </thead>
    <c:forEach items="${users}" var="user" varStatus="status">
    <tr>
        <td width="213" valign="top"><p><strong>${status.count}</strong></p></td>
        <td width="213" valign="top"><p><strong>${user.name}</strong></p></td>
        <td width="213" valign="top"><p><strong>${user.surname}</strong></p></td>
        <td width="213" valign="top"><p><strong>${user.username}</strong></p></td>
        <td width="213" valign="top"><p><strong>${user.password}</strong></p></td>
        <td width="213" valign="top"><p><strong>${user.address}</strong></p></td>

            <td width="213" valign="top"><img src="image/${user.image.id}"> </td>

    </tr>
    </c:forEach>
</table>
</body>
</html>