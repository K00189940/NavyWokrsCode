<%-- 
    Document   : DisplayAllProjects
    Created on : Dec 8, 2020, 4:36:49 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <style>
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
            }
            th, td {
                padding: 5px;
                text-align: left;
            }
        </style>
    </head>
    <body>
        <h1>Display All Projects</h1>
        <c:out value="${message}" />
        <a href="/CreateAProject/ProjectServlet?action=home">Home Page</a>
        <form action="ProjectServlet" method="get">
            <input type="hidden" name="action" value="CreateProject">
            <input type="submit" value="Create Project" >
            <br>

        </form>
        <table>
            <tr>
                <th>Title</th>
                <th>Description</th>
                <th>Department</th>
                <th>Tags</th>
               
            </tr>
            <tr>
                <c:forEach var="project" items="${AllProjects}">
                <tr>
                    <td><c:out value="${project.title}" /></td>
                    <td><c:out value="${project.description}" /></td>
                    <td><c:out value="${project.department}" /></td>
                    <td><c:out value="${project.tags}" /></td>
                </tr>
            </c:forEach>   
           
        </tr>
    </table>
    </body>
</html>
