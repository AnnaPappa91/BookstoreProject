<%-- 
    Document   : listAuthor
    Created on : Dec 29, 2019, 6:04:49 PM
    Author     : andpa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Author</title>
    </head>
    <body>
       <body>

        <h1>Διαθέσιμοι Συγγραφείς</h1>
        <a href="${pageContext.request.contextPath}/author/create">Create Author</a>

        <form:form action="${pageContext.request.contextPath}/author/search" method="GET">
            Search Name: <input type="text" name="searchName" size="10">
            <input type="submit" value="Search">
        </form:form>

        <table border="1">
            <c:forEach items="${listOfAuthor}" var="c">
                <c:url value="/author/delete" var="deleteLink" >
                    <c:param name="author_id" value="${a.id}" />
                </c:url>
                <c:url var="updateLink" value="/customer/update">
                    <c:param name="author_id" value="${a.id}" />
                </c:url>

                <tr>
                    <td>${a.id}</td>
                    <td>${a.first_name}</td>
                    <td>${a.last_name}</td>
                    <td>${a.biography}</td>
                    <td>
                        <a href="${updateLink}">Update</a>
                    </td>
                    <td>
                        <a href="${deleteLink}"
                           onclick="if (!(confirm('Are you sure you want to delete author with name: ${a.last_name}?')))
                                   return false"
                           >Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
    </body>
</html>
