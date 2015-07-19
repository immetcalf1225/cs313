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
import java.util.ArrayList;
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
            
            String sql = "INSERT INTO `goal`(`goal_name`, `goal_fin`, `goal_fail`, `user_id`) VALUES (\""
                    +goal.getName()+"\", \""+goal.getSQLDateString()+"\", \""
                    +goal.getFailString()+"\", \""+goal.getUserid()+"\");";
            
            System.out.println(sql);
            
            statement.executeUpdate(sql);
            
            conn.close();
            return true;
        } catch (Exception ex) {
            System.out.println("crash :(");
            ex.printStackTrace();
        }
        
        return false;
    }

    @Override
    public List<Goal> getAllGoal(String user_id) {
        List<Goal> goals = new ArrayList<Goal>();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            String user = "adam";    
            String pass = "eve!";
            String dbURL = "jdbc:mysql://localhost/goal";
            Connection conn = DriverManager.getConnection(dbURL, user, pass);
            
            Statement statement = conn.createStatement();
            
            String sql = "SELECT goal_name, goal_fin, goal_fail FROM goal WHERE user_id = " + user_id;
            
            ResultSet results = statement.executeQuery(sql);
            
            while(results.next()){
                int id = results.getInt("goal_id");
                String name = results.getString("goal_name");
                String fin = results.getString("goal_fin");
                String fail = results.getString("goal_fail");
                
                Goal goal = new Goal();
                goal.setGoalId(id);
                goal.setDateFromSQL(fin);
                goal.setName(name);
                goal.setFailString(fail);
                goals.add(goal);
            }
            
            results.close();
            conn.close();
            return goals;
        } catch (Exception ex) {
            
        }
        return goals;
    }

    @Override
    public boolean removeGoal(int goal_id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("are we there yet?");
            String user = "adam";    
            String pass = "eve!";
            String dbURL = "jdbc:mysql://localhost/goal";
            Connection conn = DriverManager.getConnection(dbURL, user, pass);
            
            Statement statement = conn.createStatement();
            
            String sql = "DELETE FROM goal WHERE goal_id = " + goal_id;
            System.out.println(sql);
            statement.executeUpdate(sql);
            
            conn.close();
            return true;
        } catch (Exception ex) {
            System.out.println("It crashed :(");
            ex.printStackTrace();
        }
        return false;
    }

}
