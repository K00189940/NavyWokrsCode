/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Project;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Admin
 */
public class ProjectServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //coding here 
        String action = request.getParameter("action");
        System.out.println("action = " + action);
        HttpSession session = request.getSession();
        
        String nextPage = "";
        switch (action) {
            case "RequestCreateProject":
                nextPage = "/CreateProject.html";
                break;
            
            case "home":
                nextPage = "/Home.jsp";
                break;
            case "CreateProject":
                nextPage = processCreateProject(request, session, nextPage);
                break;    
            case "saveShow":
                nextPage = processSaveProject(request, session);
                break;                
            case "RequestAllProjects":
                nextPage = processRequestAllProjects(session);
                break;
            
            default:
            
        }
        
        gotoPage(nextPage, request, response);
    }
    
    private String processCreateProject(HttpServletRequest request, HttpSession session, String nextPage) throws NumberFormatException {
        //debud info
         System.out.println("In processCreateProject");
        //get information from the user - title, description, department, tags
        
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String department = request.getParameter("department");
        String tags = request.getParameter("tags");
       
        Project project = new Project(title, description, department, tags);
        
        if (project.createProject()) {
            //send the user a message to say it was created-> view
            String message = "Project " + project.getTitle() + " was created to the system.";
            request.setAttribute("message", message);
            //display the page again - need a new list to reflect deleted project
            return this.processRequestAllProjects(session);
            
        }
        return nextPage;
    }
    
    private String processSaveProject(HttpServletRequest request, HttpSession session) throws NumberFormatException {
        String nextPage;
        System.out.println("Save project");
        //get project details 
        //get new project details from request
        //get information from the user - title, description, department, tags
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String department = request.getParameter("department");
        String tags = request.getParameter("tags");
        Project project = new Project(title, description, department, tags);
        String message = null;

        request.setAttribute("message", message);
        //display the page again - need a new list to reflect deleted book
        return this.processRequestAllProjects(session);
    }
    
    private String processRequestAllProjects(HttpSession session) {
        String nextPage;
        System.out.println("in display all projects");
        ArrayList<Project> allProjectsList = new ArrayList<>();
        Project p1 = new Project();
        allProjectsList = p1.findAllProjects();
        session.setAttribute("AllProjects", allProjectsList);
        nextPage = "/DisplayAllProjects.jsp";
        return nextPage;
    }
    
    private void gotoPage(String url, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
    
}
