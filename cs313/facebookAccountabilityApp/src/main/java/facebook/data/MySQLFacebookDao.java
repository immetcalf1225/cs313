/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebook.data;

import facebook4j.Facebook;
import isaac_netbeans.facebookaccountabilityapp.Goal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thefl_000
 */
public class MySQLFacebookDao implements FacebookDao{

    @Override
    public boolean addGoal(Goal goal) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            String user = "adam";    
            String pass = "eve!";
            String dbURL = "jdbc:mysql://localhost/goal";
            Connection conn = DriverManager.getConnection(dbURL, user, pass);
            
            Statement statement = conn.createStatement();
            
            String sql = "INSERT INTO `goal`(`goal_name`, `goal_fin`, `goal_fail`, `user_id`) VALUES ("
                    +goal.getName()+","+goal.getSQLDateString()+","
                    +goal.getFailString()+","+goal.getUserid()+")";
            ResultSet rs = statement.executeQuery(sql);
            rs.close();
            conn.close();
            return true;
        } catch (Exception ex) {
            
        }
        
        return false;
    }

    @Override
    public List<Goal> getAllGoal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeGoal(int goal_id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            String user = "adam";    
            String pass = "eve!";
            String dbURL = "jdbc:mysql://localhost/goal";
            Connection conn = DriverManager.getConnection(dbURL, user, pass);
            
            Statement statement = conn.createStatement();
            
            String sql = "DELETE FROM goal WHERE goal_id = "+goal_id;
            ResultSet rs = statement.executeQuery(sql);
            rs.close();
            conn.close();
            return true;
        } catch (Exception ex) {
            
        }
        return false;
    }

}
