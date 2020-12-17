<%-- 
    Document   : deleteBluePlayer
    Created on : Dec. 11, 2020, 5:05:53 p.m.
    Author     : Minwoo Park
--%>

<%@page import="beans.Player"%>
<%@page import="data.PlayerDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Delete Player </h1>
        
        <br>Are you sure you want to delete ${player.name} ?
        
        <form  action="DeleteBluePlayerServlet" method="GET">
                 <input type="hidden" name="id" value=${player.ID}>
            <br><input type="submit" name="action" value="Yes">
                <input type="submit" name="action" value="Cancel">
        </form>
    </body>
</html>
