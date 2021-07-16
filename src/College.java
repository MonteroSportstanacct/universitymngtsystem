//for college
public class College {
    private String college_id;
    private String college_name;
    
    public College() {  }
    
    public College(String collegeid, String collegename) {
        this.college_id = collegeid;
        this.college_name = collegename;
    }

  
    public String getCollege_id() {
        return college_id;
    }

    public void setCollege_id(String collegeid) {
        this.college_id = collegeid;
    }

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String collegename) {
        this.college_name = collegename;
    }

}
