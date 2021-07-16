
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CourseLoadQuery {
    
    public void updateCourseInstructor(String emp_ID, String co_ID)
    {
        Connection con = myConnection.getConnection();
        PreparedStatement ps;
        String updateQuery = "UPDATE course SET `employee_id` ='"+emp_ID+"' WHERE course_id = '"+co_ID+"'";
        try{
            ps = con.prepareStatement(updateQuery);
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Selected Instructor Assigned on Course ID ("+co_ID +")\nSuccessful"); 
                } 
                else{
                    JOptionPane.showMessageDialog(null, "Error\n Something went wrong\n Contact IT Personnel Immediately!");  
                }
        }catch (SQLException ex) {
            Logger.getLogger(CourseLoadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }  
public void deleteCourseInstructor(String emp_ID, String co_ID)
    {
        Connection con = myConnection.getConnection();
        PreparedStatement ps;
        String updateQuery = "UPDATE course SET employee_id='' where course_ID ='"+co_ID+"'";
        try{
            ps = con.prepareStatement(updateQuery);
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "The Instructor in (" +co_ID +")has been unassigned!");        
                } 
                else{
                    JOptionPane.showMessageDialog(null, "Something went wrong!");
                   
                }
        }catch (SQLException ex) {
            Logger.getLogger(Mastersubject.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public ArrayList<CourseLoading> courseLoadList(String ID)
    {
        ArrayList<CourseLoading> clist = new ArrayList<CourseLoading>();
        Connection con = myConnection.getConnection();
    
        Statement st;
        ResultSet rs;
        try{
            st = con.createStatement();  
            // CLA
            if(ID!=null)
            {
                rs = st.executeQuery("SELECT course.course_ID, course.course_name, course.college_ID, case WHEN instructor.employee_name is NULL then 'Unassigned' WHEN instructor.employee_name='' then 'Unassigned' else instructor.employee_name END as employee_name FROM course LEFT JOIN instructor on course.employee_ID = instructor.employee_ID where course.college_ID='"+ID+"'");
            }
            else{
                rs = st.executeQuery("SELECT course.course_ID, course.course_name, course.college_ID, case WHEN instructor.employee_name is NULL then 'Unassigned' else instructor.employee_name END as employee_name FROM course LEFT JOIN instructor on course.employee_ID = instructor.employee_ID");
            }
            CourseLoading c;
            while(rs.next())
            {
                c = new CourseLoading(rs.getString("Course_ID"), rs.getString("Course_name"),  rs.getString("College_ID"), rs.getString("employee_name"));
                clist.add(c);
            }
       }catch(SQLException ex){
        Logger.getLogger(CourseQuery.class.getName()).log(Level.SEVERE, null, ex);
    }
        return clist;
    }
}
