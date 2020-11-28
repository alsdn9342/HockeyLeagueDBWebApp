<%-- 
    Document   : addBluePlayer
    Created on : Nov. 25, 2020, 8:49:05 a.m.
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
        <h1>Add Blue Player</h1>
        <form action="BluePlayerControllerServlet" method="GET">
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
