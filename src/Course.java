
public class Course {
    private String course_id;
    private String course_name;
    private String college_id;
    private String employee_id;
    
    public Course() {  }
    
    public Course(String courseid, String coursename, String collegeid, String employeeid) {
        this.course_id = courseid;
        this.course_name = coursename;
        this.college_id = collegeid;
        this.employee_id = employeeid;
    }
    
    //setter getter

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String courseid) {
        this.course_id = courseid;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String coursename) {
        this.course_name = coursename;
    }

    public String getCollege_id() {
        return college_id;
    }

    public void setCollege_id(String collegeid) {
        this.college_id = collegeid;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employeeid) {
        this.employee_id = employeeid;
    }
    public String getCollegeName()
    {
        return college_id;
    }
    
}
