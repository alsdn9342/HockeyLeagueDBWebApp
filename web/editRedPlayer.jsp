<%-- 
    Document   : editPlayer
    Created on : Nov. 23, 2020, 8:33:30 p.m.
    Author     : Minwoo Park
--%>

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
        <h1>Edit player, ${player.name}</h1>                          
        <form action="EditRedPlayerServlet" method="GET">
            <input type="hidden" size="20" name="id" value="${player.ID}">         
            <br>Name:<input type="text" size="20" name="name" value="${player.name}">
            <br>Address:<input type="text" size="20" name="address" value="${player.address}">
            <br>Team <input type="text" size="20" name="team" value="${player.team}" >
            <br>Role <input type="text" size="20" name="role" value="${player.role}">
            <br>Active<input type="checkbox" name="active" checked>
            <br><input type="submit" name="action" value="Save">
            <input type="submit" name="action" value="Cancel">
        </form>    
    </body>
</html>
