<%-- 
    Document   : viewBlueTeam
    Created on : Nov. 23, 2020, 3:44:44 p.m.
    Author     : Minwoo Park
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="data.PlayerDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.Player"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Blue Team</h1>
        <c:if test="${empty bluePlayers}">         
            NO Player
        </c:if>

        <c:if test="${not empty bluePlayers}"> 

        <li>
            <c:forEach var="bluePlayers" items="${bluePlayers}">
                <table>
                    <tr>
                        <td>Name</td><td>Address</td><td>Team</td><td>Role</td><td>Activeness</td><td></td><td></td>
                    </tr>
                    <tr>
                        <td>${bluePlayers.name}</td>
                        <td>${bluePlayers.address}</td>
                        <td>${bluePlayers.team}</td>
                        <td>${bluePlayers.role}</td></td>
                        <td>${bluePlayers.actveOrNot}</td>
                        <td>
                            <form action="EditBluePlayerServlet" method="GET">
                                <input type="hidden" name="id" value="${bluePlayers.ID}">
                                <input type="submit" name="action" value="Edit">
                            </form>
                        </td>
                        <td>
                            <form action="DeleteBluePlayerServlet" method="GET">
                                <input type="hidden" name="id" value="${bluePlayers.ID}">
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
    <br><br><a href="addBluePlayer.jsp">add Player</a>
    <br><a href="index.jsp">Go back to main...</a>
</body>
</html>
