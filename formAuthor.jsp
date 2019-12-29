<%-- 
    Document   : formAuthor
    Created on : Dec 29, 2019, 6:10:32 PM
    Author     : andpa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        body>
        <c:choose>
            <c:when test="${a.id != 0}">
                <h1>Update Author</h1>
            </c:when>
            <c:otherwise>
                <h1>Create Author</h1>
            </c:otherwise>
        </c:choose>
            <form:form id="formAuthor"
            action="${pageContext.request.contextPath}/author/create" 
            method="POST"
            modelAttribute="author">
            <form:hidden path="id"/>
            Name: <form:input id="first_name" path="first_name"/>
            Name: <form:input id="last_name" path="last_name"/>
            <br/>
            <input type="submit" value="Submit">
        </form:form>
        <br/>
        <a href="${pageContext.request.contextPath}/author/list">Back to list</a>
    </body>
    </body>
</html>
