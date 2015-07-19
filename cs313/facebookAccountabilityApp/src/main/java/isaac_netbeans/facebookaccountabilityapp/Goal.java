/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isaac_netbeans.facebookaccountabilityapp;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Kevin Johnson (joh06018 at byui.edu)
 */
public class Goal {
    private String userid;
    private String name;
    private String failString;
    private Calendar calendar; // this holds both the date and the time at once
    private int goalId;

    public Goal(String userid, String name, String failString, Calendar endCalendar, int goalId) {
        this.userid = userid;
        this.name = name;
        this.failString = failString;
        this.calendar = endCalendar;
        this.goalId = goalId;
    }

    public Goal() {
        this.userid = "";
        this.name = "";
        this.failString = "";
        this.calendar = Calendar.getInstance();
        this.goalId = -1;
    }

    public int getGoalId() {
        return goalId;
    }

    public void setGoalId(int goalId) {
        this.goalId = goalId;
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

    public String getFailString() {
        return failString;
    }

    public void setFailString(String failString) {
        this.failString = failString;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public String getDateString() {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        
        String yearS = ("0000" + year).substring(Integer.toString(year).length());
        String monthS = ("00" + month).substring(Integer.toString(month).length());
        String dayS = ("00" + day).substring(Integer.toString(day).length());
        
        String hourS = ("00" + hour).substring(Integer.toString(hour).length());
        String minuteS = ("00" + minute).substring(Integer.toString(minute).length());
        String secondS = "00";
        
        return yearS + "-" + monthS + "-" + dayS + " " + hourS + ":" + minuteS + ":" + secondS;
    }
    
    public String getSQLDateString() {
        // YYYY-MM-DD HH:MM:SS
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        
        String yearS = ("0000" + year).substring(Integer.toString(year).length());
        String monthS = ("00" + month).substring(Integer.toString(month).length());
        String dayS = ("00" + day).substring(Integer.toString(day).length());
        
        String hourS = ("00" + hour).substring(Integer.toString(hour).length());
        String minuteS = ("00" + minute).substring(Integer.toString(minute).length());
        String secondS = "00";
        
        return yearS + "-" + monthS + "-" + dayS + " " + hourS + ":" + minuteS + ":" + secondS;
        
    }
    
    public void setDateFromSQL(String datetime) {
        // YYYY-MM-DD HH:MM:SS
        
        int year = Integer.parseInt(datetime.substring(0,4));
        int month = Integer.parseInt(datetime.substring(5,7));
        int day = Integer.parseInt(datetime.substring(8,10));
        int hour = Integer.parseInt(datetime.substring(11,13));
        int minute = Integer.parseInt(datetime.substring(14,16));
        
        calendar.set(year, month, day, hour, minute, 0);
    }
    
    public Date getDateAsDate() {
        return calendar.getTime();
    }
    
}
