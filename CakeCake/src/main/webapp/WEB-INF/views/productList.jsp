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
<h1>The product list</h1>
<table border="1" cellspacing="0" cellpadding="0">
    <thead>
    <td width="213" valign="top"><p><strong>no.</strong></p></td>
    <td width="213" valign="top"><p><strong>Product name</strong></p></td>
    <td width="213" valign="top"><p><strong>Description</strong></p></td>
    <td width="213" valign="top"><p><strong>Price</strong></p></td>


    </thead>
    <c:forEach items="${products}" var="product" varStatus="status">
        <tr>
            <td width="213" valign="top"><p><strong>${status.count}</strong></p></td>
            <td width="213" valign="top"><p><strong>${product.name}</strong></p></td>
            <td width="213" valign="top"><p><strong>${product.des}</strong></p></td>
            <td width="213" valign="top"><p><strong>${product.price}</strong></p></td>

            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <td width="213" valign="top"><img src="image/${product.image.id}"> </td>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <td width="213" valign="top"><p><strong><a href="update/{id}" >Edit</a></strong></td>
            </sec:authorize>
        </tr>
    </c:forEach>
</table>
</body>
</html>