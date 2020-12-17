<%-- 
    Document   : index
    Created on : Nov. 23, 2020, 3:33:46 p.m.
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
        <h1>Hockey Team</h1>
        <form action="TeamChoiceServlet" method="GET">
            Team: <select name="team">
                <option value="red">Red</option>
                    <option value="blue">Blue</option>
                  </select>
            <br><br><input type="submit" name="action" value="Select">
        </form>
    </body>
</html>
