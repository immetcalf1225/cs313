/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebook.data;

import facebook.bll.Thegoal;
import isaac_netbeans.facebookaccountabilityapp.Goal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author thefl_000
 */
public class MySQLFacebookDao implements FacebookDao{

    @Override
    public boolean addGoal(Goal goal) {
        
        // make the query from the goal stuff
        
        // actually do above query
        
        // do a dance
        
        return false;
    }

    @Override
    public List<Thegoal> getAllGoal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeGoal(Thegoal goal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
