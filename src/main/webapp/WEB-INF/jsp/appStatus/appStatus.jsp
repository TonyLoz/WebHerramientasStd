<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${initParam.appTitle} - Estatus Ap</title>
    </head>
    <body>
        <h1>${initParam.appTitle}&nbsp;${initParam.appVersion}</h1>
        <h2>Estado: ${appStatus}</h2>
        <table>
            <c:forEach var="component" items="${testedComponentsList}">
                <tr>
                    <td>${component.component}:</td>
                    <td>${component.status}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>