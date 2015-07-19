/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isaac_netbeans.facebookaccountabilityapp;

import com.sun.media.jfxmedia.logging.Logger;
import facebook.data.FacebookDao;
import facebook.data.MySQLFacebookDao;
import facebook4j.Facebook;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kevin Johnson (joh06018 at byui.edu)
 */
@WebServlet(name = "CreateGoal", urlPatterns = {"/CreateGoal"})
public class CreateGoal extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");
        
        // get the post data and process it
        // make sure to validate it one more time to ensure all of it is there
        // and that the goal end time is after the current time.
        
        if (facebook == null) {
            response.sendRedirect("./welcome.jsp");
        }
                
        // get the variables
        String userid = null;
        try {
            userid = facebook.getId();
        } catch (Exception ex) {
            Logger.logMsg(1, "Unable to access userid from Facebook session. Aborting goal creation.");
        }
        
        if (userid == null) {
            response.sendRedirect("./welcome.jsp");
        }
        // validate said variables
        // endDate, endTime, name, failure
        
        String endDate = request.getParameter("endDate");
        String endTime = request.getParameter("endTime");
        String name = request.getParameter("name");
        String failure = request.getParameter("failure");
                
        // redirect if anything is missing
        if (name == null || failure == null || endDate == null || endTime == null) {
            response.sendRedirect("./welcome.jsp");
        }
        
        // format the datetime
        int year = Integer.parseInt(endDate.substring(0,4));
        int month = Integer.parseInt(endDate.substring(5,7)) - 1;
        int day = Integer.parseInt(endDate.substring(8,10));
        int hour = Integer.parseInt(endTime.substring(0,2));
        int minute = Integer.parseInt(endTime.substring(3,5));
        
        Calendar calendar = Calendar.getInstance();
        
        calendar.set(year, month, day, hour, minute, 0);
        
        
        // compile the data into a goal object
        Goal goal = new Goal(userid, name, failure, calendar, 0);
        
        // Send the goal object to the database class
        new MySQLFacebookDao().addGoal(goal);
        
        
        response.sendRedirect("./welcome.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
