package Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


public class Project implements Serializable {
    private int projectID;
    private String title;
    private String description;
    private String department;
    private String tags;
    
    public Project(String title, String description, String department, String tags) {
        this.title = title;
        this.description = description;
        this.department = department;
        this.tags = tags;
    }
    
    public Project(int projectID, String title, String description, String department, String tags) {
        this.projectID = projectID;
        this.title = title;
        this.description = description;
        this.department = department;
        this.tags = tags;
    }
    
    public Project(){
        
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
    
    public boolean createProject(){
       
        ProjectDB projectdb = new ProjectDB(title, description, department, tags);        
        return projectdb.createProject();
    }
    
    public ArrayList<Project> findAllProjects() { 
    
        ProjectDB projectdb = new ProjectDB();
        return projectdb.findAllProjects();
     
    }
}
