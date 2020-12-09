<%-- 
    Document   : Home
    Created on : Dec 8, 2020, 4:42:30 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create Project Page</h1>
    </body>
    
      <form action="ProjectServlet" method="get">
         <input type="hidden" name="action" value="RequestAllProjects">
         <input type="submit" value="Projects" >
         <br>
         
    </form>
    
    <c:out value="${message}" />
</html>
