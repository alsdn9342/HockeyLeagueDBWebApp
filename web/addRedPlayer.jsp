<%-- 
    Document   : addPlayer
    Created on : Nov. 23, 2020, 4:01:24 p.m.
    Author     : Minwoo Park
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add Red Player</h1>
        <form action="RedPlayerControllerServlet" method="GET">
             <input type="hidden" size="20" name="id">
            <br>Name:<input type="text" size="20" name="name">
            <br>Address:<input type="text" size="20" name="address">
            <br>Team <input type="text" size="20" name="team" >
            <br>Role <input type="text" size="20" name="role">
            <br>Active<input type="checkbox" name="active">
            <br><input type="submit" name="action" value="Add">
                <input type="submit" name="action" value="Cancel">
        </form>    
    </body>
</html>
