/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isaac_netbeans.facebookaccountabilityapp;

import java.util.Calendar;

/**
 *
 * @author Kevin Johnson (joh06018 at byui.edu)
 */
public class Goal {
    private String userid;
    private String name;
    private String description;
    private Calendar calendar; // this holds both the date and the time at once

    public Goal(String userid, String name, String description, Calendar endCalendar) {
        this.userid = userid;
        this.name = name;
        this.description = description;
        this.calendar = endCalendar;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public String getDateString() {
        //TODO: implement
        
        return null;
    }
    
    public String getTimeString() {
        // TODO: implement
        return null;
    }
    
    
    
}
