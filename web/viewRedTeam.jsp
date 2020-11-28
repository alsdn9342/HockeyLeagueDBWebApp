<%-- 
    Document   : viewAllPlayers
    Created on : Nov. 23, 2020, 3:42:10 p.m.
    Author     : Minwoo Park
--%>

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
        <h1>Red Team</h1>
        <%
            ArrayList<Player> redPlayers = (ArrayList<Player>) session.getAttribute("redPlayers");
            if (redPlayers == null || redPlayers.size() == 0) {
        %>           
        NO Player
        <%} else {%>
    <li>

        <%
            for (Player redPlayer : redPlayers) {
        %>
        <table>
            <tr>
                <td>Name</td><td>Address</td><td>Team</td><td>Role</td><td>Activeness</td><td></td><td></td>
            </tr>
            <tr>
                <td><%=redPlayer.getName()%></td>
                <td><%=redPlayer.getAddress()%></td>
                <td><%=redPlayer.getTeam()%></td>
                <td><%=redPlayer.getRole()%></td>
                <td><%=redPlayer.isActive()%></td>
                <td>
                    <form action="editRedPlayer.jsp" method="GET">
                        <input type="hidden" name="id" value="<%=redPlayer.getID()%>">
                        <input type="hidden" name="name" value="<%=redPlayer.getName()%>">
                        <input type="hidden" name="address" value="<%=redPlayer.getAddress()%>">
                        <input type="hidden" name="team" value="<%=redPlayer.getTeam()%>">
                        <input type="hidden" name="role" value="<%=redPlayer.getRole()%>">
                        <input type="hidden" name="action" value="<%=redPlayer.isActive()%>">
                        <input type="submit" name="action" value="Edit">
                    </form>
                </td>
                <td>
                    <form action="DeleteRedPlayerServlet" method="GET">
                        <input type="hidden" name="name" value="<%=redPlayer.getName()%>">
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
        </table>
        <br><br>
        <%}%>
    </li><%
        }
    %>
    <br><a href="index.jsp">Go back to main...</a>
</body>
</html>
