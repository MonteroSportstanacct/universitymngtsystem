
public class Instructor {
    
    private String employee_id;
    private String employee_name;
    private String college_id;
    
    public Instructor() {  }
    
    public Instructor(String eid, String n, String cid) {
        this.employee_id = eid;
        this.employee_name = n;
        this.college_id = cid;   
    }
    
    //setter getter
    public String getEmpid() {
        return this.employee_id;
    }
    
    public String getName() {
        return this.employee_name;
    }
    
    public String getCollegeid() {
        return this.college_id;
    }
    
    
    
    public void setEmpid(String eid) {
        this.employee_id = eid;
    }
    
    public void setName(String n) {
        this.employee_name = n;
    }
    
    public void setCollegeid(String cid) {
        this.college_id = cid;
    }
    
}
