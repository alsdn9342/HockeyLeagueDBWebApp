<%-- 
    Document   : editBluePlayer
    Created on : Nov. 25, 2020, 8:54:14 a.m.
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
        <%
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String team = request.getParameter("team");
        String role = request.getParameter("role");
        String id = request.getParameter("id");
        %>
                                                  
        <h1>Edit Blue player, <%=name %></h1>                          
        <form action="EditBluePlayerServlet" method="GET">
            <input type="hidden" size="20" name="id" value="<%=id%>">
            <br>Name:<input type="text" size="20" name="name" value="<%=name%>">
            <br>Address:<input type="text" size="20" name="address" value="<%=address%>">
            <br>Team <input type="text" size="20" name="team" value="<%=team%>" >
            <br>Role <input type="text" size="20" name="role" value="<%=role%>">
            <br>Active<input type="checkbox" name="active" checked>
            <br><input type="submit" name="action" value="Save">
                <input type="submit" name="action" value="Cancel">
        </form>
    </body>
</html>
