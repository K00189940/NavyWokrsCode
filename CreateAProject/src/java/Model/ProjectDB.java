/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProjectDB {
    private int projectID;
    private String title;
    private String description;
    private String department;
    private String tags;
    
    public ProjectDB(String title, String description, String department, String tags) {
        this.title = title;
        this.description = description;
        this.department = department;
        this.tags = tags;
    }
    
    public ProjectDB(int projectID, String title, String description, String department, String tags) {
        this.projectID = projectID;
        this.title = title;
        this.description = description;
        this.department = department;
        this.tags = tags;
    }
    
    public ProjectDB(){
        
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    public boolean createProject() {
     //   boolean inserted = false;

        Connection c = DatabaseHelper.getConnection();
        String template = "INSERT INTO Project (title, description, department, tags) VALUES (?,?,?,?)";
        if (c != null) {
            try {
                PreparedStatement inserter = c.prepareStatement(template);
                inserter.setString(1, this.title);
                inserter.setString(2, this.description);
                inserter.setString(3, this.department);
                inserter.setString(4, this.tags);
                int i = inserter.executeUpdate();
                return true;
            } catch (SQLException ex) {
                System.out.println("Error on find all " + ex);
                return false;
            }
           
        }  
        return true;
    }
    
    public ArrayList<Project> findAllProjects() {

        System.out.println(" find all projects");
        ArrayList<Project> allProjects = new ArrayList<Project>();

        Connection c = DatabaseHelper.getConnection();

        String template = "SELECT * FROM Project;";

        if (c != null) {
            try {
                PreparedStatement inserter = c.prepareStatement(template);
                ResultSet resultSet = inserter.executeQuery();

                while (resultSet.next()) {
                    Project project = new Project();
                    project.setProjectID(resultSet.getInt("projectID"));
                    project.setTitle(resultSet.getString("title"));
                    project.setDescription(resultSet.getString("description"));
                    project.setDepartment(resultSet.getString("department"));
                    project.setTags(resultSet.getString("tags"));

                    allProjects.add(project);

                }

                System.out.println(inserter);
                inserter.close();
                c.close();
            } catch (SQLException ex) {
                System.out.println("Error on find all " + ex);
            }

        }
        return allProjects;
    }

}