<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
    Document   : headerMember
    Created on : Feb 20, 2013, 1:58:06 AM
    Author     : Takeit
--%>
<sec:authorize access="!hasRole('ROLE_ADMIN')">
    <sec:authorize access="hasRole('ROLE_MEMBER')">

        <a href="logout">Logout</a>
        ${sessionScope.userSession.name}
    </sec:authorize>
</sec:authorize>

