import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CollegeQuery {

    
public void insertCollege(College col)
{
    
    Connection con = myConnection.getConnection();
    PreparedStatement ps;
      
    try {                                        
            ps = con.prepareStatement("INSERT INTO college (`college_id`, `college_name`) VALUES (?,?)");
            ps.setString(1, col.getCollege_id());
            ps.setString(2, col.getCollege_name());           
            if(ps.executeUpdate() != 0) {
                        JOptionPane.showMessageDialog(null, "New College Added Successfully!");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Something Went Wrong\nContact Our IT personnel immediately");
                        
                    }
        } catch (SQLException ex) {
            Logger.getLogger(CollegeQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}

public void editCollege(College col, String collegeid)
{
    Connection con = myConnection.getConnection();
    PreparedStatement ps;
      
    try {                               
            ps = con.prepareStatement("UPDATE college SET `college_id` = ?, `college_name` = ? WHERE college_id = '"+collegeid+"'");
            ps.setString(1, col.getCollege_id());
            ps.setString(2, col.getCollege_name());
            if(ps.executeUpdate() != 0) {
                        JOptionPane.showMessageDialog(null, "College ("+collegeid+") has been edited");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Something Went Wrong\nContact Our IT personnel immediately");
                        
                    }
        } catch (SQLException ex) {
            Logger.getLogger(CollegeQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
}

public void deleteCollege(String cid)
{
    Connection con = myConnection.getConnection();
        PreparedStatement ps;
        
        try {
            ps = con.prepareStatement("DELETE FROM college WHERE `college_id` = ? ");
            ps.setString(1, cid);
           
            
            if(ps.executeUpdate() != 0) {
                        JOptionPane.showMessageDialog(null, "College ("+cid+") has been deleted");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Something Went Wrong\nContact Our IT personnel immediately");
                        
                    }
        } catch (SQLException ex) {
            Logger.getLogger(CollegeQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
}


public ArrayList<College> collegeDisplay(String collegeid) {

    ArrayList<College> colDisp = new ArrayList<>();
    
    Connection con = myConnection.getConnection();
    Statement st;
    ResultSet rs;
    
    try{
        st = con.createStatement();
        rs = st.executeQuery("SELECT `college_id`, `college_name` FROM college WHERE college_id='"+collegeid+"'");
        
        College col;
        while(rs.next()) {
        
            col = new College(rs.getString("college_id"), rs.getString("college_name"));
            colDisp.add(col);
        }
        
        
    }catch(Exception ex){
        Logger.getLogger(CollegeQuery.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return colDisp;

}

public ArrayList<College> collegeList(){
    
    ArrayList<College> colList = new ArrayList<>();

    Connection con = myConnection.getConnection();    
    Statement st;
    ResultSet rs;
    try{
        st = con.createStatement();        
        rs = st.executeQuery("SELECT `college_id`, `college_name` FROM college");
        College col;
        while(rs.next())
        {
            col = new College(rs.getString("college_id"), rs.getString("college_name"));
            colList.add(col);
        }
        
    }catch(Exception e)
    {
        System.out.println(e.getMessage());
    }
    return colList;

}    
}
