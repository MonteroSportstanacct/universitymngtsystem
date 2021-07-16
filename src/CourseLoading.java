public class CourseLoading {
    private String course_id;
    private String course_name;
    private String college_id;
    private String Instructor_Name;
    
    public CourseLoading(){}    
    public CourseLoading(String co_id, String cname, String col_id, String iname )
    {
        this.course_id = co_id;
        this.course_name = cname;
        this.college_id = col_id;
        this.Instructor_Name = iname;
    }    
    public String getCourseID()
    {   return this.course_id; }
    public void setCourseID(String co_id)
    {  this.course_id = co_id; }
    public String getCourseName()
    {  return this.course_name; }
    public void setCourseName(String cname)
    {  this.course_name = cname; }
    public String getCollegeID()
    {  return this.college_id;  }
    public void setCollegeID(String col_id)
    {  this.college_id = col_id; }
    public String getEmployee_name()
    {  return this.Instructor_Name;  }
    public void setEmployeeName(String iname)
    {  this.Instructor_Name = iname; }
            
}
