/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebook.bll;

import java.util.Date;

/**
 *
 * @author thefl_000
 */
public class Thegoal {
    private int goal_id;
    private String goal_name;
    private String goal_desc;
    private Date goal_start;
    private Date goal_fin;
    private String goal_fail;
    private int user_id;

    public int getGoal_id() {
        return goal_id;
    }

    public void setGoal_id(int goal_id) {
        this.goal_id = goal_id;
    }

    public String getGoal_name() {
        return goal_name;
    }

    public void setGoal_name(String goal_name) {
        this.goal_name = goal_name;
    }

    public String getGoal_desc() {
        return goal_desc;
    }

    public void setGoal_desc(String goal_desc) {
        this.goal_desc = goal_desc;
    }

    public Date getGoal_start() {
        return goal_start;
    }

    public void setGoal_start(Date goal_start) {
        this.goal_start = goal_start;
    }

    public Date getGoal_fin() {
        return goal_fin;
    }

    public void setGoal_fin(Date goal_fin) {
        this.goal_fin = goal_fin;
    }

    public String getGoal_fail() {
        return goal_fail;
    }

    public void setGoal_fail(String goal_fail) {
        this.goal_fail = goal_fail;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    
}
