<%-- 
    Document   : viewAllPlayers
    Created on : Nov. 23, 2020, 3:42:10 p.m.
    Author     : Minwoo Park
--%>

<%@page import="data.PlayerDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.Player"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Red Team</h1>
        <c:if test="${empty redPlayers}">
            No Players
        </c:if>

        <c:if test="${not empty redPlayers}">    
        <li>
            <c:forEach var="redPlayers" items="${redPlayers}">

                <table>
                    <tr>
                        <td>Name</td><td>Address</td><td>Team</td><td>Role</td><td>Activeness</td><td></td><td></td>
                    </tr>
                    <tr>
                        <td>${redPlayers.name}</td>
                        <td>${redPlayers.address}</td>
                        <td>${redPlayers.team}</td>
                        <td>${redPlayers.role}
                        </td><td>${redPlayers.actveOrNot}</td>
                        <td>
                            <form action="EditRedPlayerServlet" method="GET">
                                <input type="hidden" name="id" value="${redPlayers.ID}">
                                <input type="submit" name="action" value="Edit">
                            </form>
                        </td>
                        <td>
                            <form action="DeleteRedPlayerServlet" method="GET">
                                <input type="hidden" name="id" value="${redPlayers.ID}">
                                <input type="submit" name="action" value="Delete">
                            </form>
                        </td>
                    </tr>
                </table>
                <br><br>
            </c:forEach>
        </li>
    </c:if>



    <br>
    <br><a href="addRedPlayer.jsp">add player</a>
    <br><a href="index.jsp">Go back to main...</a>
</body>
</html>
