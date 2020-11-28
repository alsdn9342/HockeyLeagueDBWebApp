<%-- 
    Document   : viewBlueTeam
    Created on : Nov. 23, 2020, 3:44:44 p.m.
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
        <h1>Blue Team</h1>
        <%
            ArrayList<Player> bluePlayers = (ArrayList<Player>) session.getAttribute("bluePlayers");
            if (bluePlayers == null || bluePlayers.size() == 0) {
        %>           
        NO Player
        <%} else {%>
    <li>

        <%
            for (Player bluePlayer : bluePlayers) {
        %>
        <table>
            <tr>
                <td>Name</td><td>Address</td><td>Team</td><td>Role</td><td>Activeness</td><td></td><td></td>
            </tr>
            <tr>
                <td><%=bluePlayer.getName()%></td>
                <td><%=bluePlayer.getAddress()%></td>
                <td><%=bluePlayer.getTeam()%></td>
                <td><%=bluePlayer.getRole()%></td>
                <td><%=bluePlayer.isActive()%></td>
                <td>
                    <form action="editBluePlayer.jsp" method="GET">
                        <input type="hidden" name="id" value="<%=bluePlayer.getID()%>">
                        <input type="hidden" name="name" value="<%=bluePlayer.getName()%>">
                        <input type="hidden" name="address" value="<%=bluePlayer.getAddress()%>">
                        <input type="hidden" name="team" value="<%=bluePlayer.getTeam()%>">
                        <input type="hidden" name="role" value="<%=bluePlayer.getRole()%>">
                        <input type="hidden" name="action" value="<%=bluePlayer.isActive()%>">
                        <input type="submit" name="action" value="Edit">
                    </form>
                </td>
                <td>
                    <form action="DeleteBluePlayerServlet" method="GET">
                        <input type="hidden" name="name" value="<%=bluePlayer.getName()%>">
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
        </table>
        <br><br>
        <%}%>
    </li>        
    <%
        }
    %>
    <br><a href="index.jsp">Go back to main...</a>
</body>
</html>
