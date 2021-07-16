
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class InstructorQuery {
    
    public ArrayList<Instructor> instructorDisplay(String ID)
{
    ArrayList<Instructor> ilist = new ArrayList<>();
    Connection con = myConnection.getConnection();
    Statement st;
    ResultSet rs;
    try{
        st = con.createStatement();  
        if(ID!=null)
        {
            rs = st.executeQuery("SELECT `employee_id`, `employee_name`, college.college_id FROM instructor, college WHERE instructor.college_id = college.college_id and instructor.employee_id = '"+ID+"'");
            Instructor i;
            while(rs.next()){
            i = new Instructor(rs.getString("employee_id"), rs.getString("employee_name"), rs.getString("college_id"));
            ilist.add(i);
            }
        }
        
    }catch(SQLException ex){
        Logger.getLogger(CourseQuery.class.getName()).log(Level.SEVERE, null, ex);
    }
    return ilist;
}                                   
    
    
    public ArrayList<Instructor> instructorList(String ID){
    ArrayList<Instructor> ilist = new ArrayList<>();
    Connection con = myConnection.getConnection();
    
    Statement st;
    ResultSet rs;
    
    try{
        st = con.createStatement();        
        
        if(ID!=null)
        {
            
            rs = st.executeQuery("SELECT `employee_id`, `employee_name`, college.college_name as college_name FROM instructor, college WHERE instructor.college_id = college.college_id AND instructor.college_id ='"+ID+"' ORDER BY college.college_name");       
        }
        else
            rs = st.executeQuery("SELECT `employee_id`, `employee_name`, college.college_name as college_name FROM instructor, college WHERE instructor.college_id = college.college_id ORDER BY college.college_name");
        Instructor i;
        while(rs.next()){
            i = new Instructor(rs.getString("employee_id"), rs.getString("employee_name"), rs.getString("college_name"));
            ilist.add(i);
            }
    }catch(SQLException ex){
        Logger.getLogger(CourseQuery.class.getName()).log(Level.SEVERE, null, ex);
    }
    return ilist;    
 }     
    
    public void insertInstructor(Instructor in){
    Connection con = myConnection.getConnection();
    PreparedStatement ps;
    try{
        
        ps = con.prepareStatement("INSERT INTO instructor (`employee_id`, `employee_name`, `college_id`) VALUES (?,?,?)");
        ps.setString(1, in.getEmpid());
        ps.setString(2, in.getName()); 
        ps.setString(3, in.getCollegeid());
        if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "New Instructor Added Successfully");               
                } 
                else{
                    JOptionPane.showMessageDialog(null, "Something Went Wrong\nContact Our IT personnel immediately");
                }
    }catch(SQLException ex) {
            Logger.getLogger(CourseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    public void editInstructor(Instructor i, String cid)
{
    Connection con = myConnection.getConnection();
    PreparedStatement ps;
    
    try{
        
        ps = con.prepareStatement("UPDATE instructor SET `employee_id` = ?, `employee_name` = ?, `college_id` = ? WHERE employee_id = '"+cid+"'");
        ps.setString(1, i.getEmpid());
        ps.setString(2, i.getName()); 
        ps.setString(3, i.getCollegeid()); 
        if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Instructor ("+cid+") Edited Successfully");               
                } 
                else{
                    JOptionPane.showMessageDialog(null, "Something Went Wrong\nContact Our IT personnel immediately");      
                }
    }catch(SQLException ex) {
            Logger.getLogger(CourseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    public void deleteInstructor(String cid)
{
    Connection con = myConnection.getConnection();
    PreparedStatement ps;
        
        try {
            ps = con.prepareStatement("DELETE FROM instructor WHERE `employee_id` = ?");
            ps.setString(1, cid);   
            if(ps.executeUpdate() != 0) {
                        JOptionPane.showMessageDialog(null, "Instructor Removed Successfully!");
                    }
                    else {
                       JOptionPane.showMessageDialog(null, "Something Went Wrong\nContact Our IT personnel immediately");     
                    }
        } catch (SQLException ex) {
            Logger.getLogger(CollegeQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
}
