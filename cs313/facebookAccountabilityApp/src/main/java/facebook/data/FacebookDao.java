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
public interface FacebookDao {
    //insert
     boolean addGoal(int goal_id, String goal_name, String goal_desc,
             Date goal_start, Date goal_fin, int user_id);

    //read
    List<Thegoal> getAllGoal();

    //delete
    boolean removeGoal(Thegoal goal);
}
