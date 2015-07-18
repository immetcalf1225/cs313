/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebook.data;

import facebook.bll.Thegoal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author thefl_000
 */
public class MySQLFacebookDao implements FacebookDao{

    @Override
    public boolean addGoal(int goal_id, String goal_name, String goal_desc, Date goal_start, Date goal_fin, int user_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
