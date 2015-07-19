<%-- 
    Document   : welcome
    Created on : Jun 24, 2015, 4:30:03 PM
    Author     : isaacmetcalf
--%>

<%@page import="java.util.Collections"%>
<%@page import="java.util.Date"%>
<%@page import="facebook4j.FacebookException"%>
<%@page import="facebook.data.FacebookDao"%>
<%@page import="java.util.Calendar"%>
<%@page import="facebook.data.MySQLFacebookDao"%>
<%@page import="facebook4j.Facebook"%>
<%@page import="isaac_netbeans.facebookaccountabilityapp.Goal"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" type="text/css" href="AccountabilityApp.css">
        <link href='http://fonts.googleapis.com/css?family=Cabin' rel='stylesheet' type='text/css'>
        
        <script>
            function deleteGoal(goalId) {
                
                window.location='./DeleteGoal?goalid=' + goalId;
                
            }
            
            
        </script>
        
        
        <title>Welcome</title>
    </head>
    <body>
        <p>Congratulations, you are now logged in!</p>
 
        <form action="newGoal.jsp" method="get">
            <div class="container">
                <button type="submit" class="btn btn-primary">Create Goal</button>
            </div>
        </form>
        <br/>
        <form action="PostToPage" method="get">
            <div class="container"> 
                <button type="submit" class="btn btn-primary">Post to Page</button>
            </div>
        </form>

        <!-- list posts -->
        <%
            Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");
            String userid = null;
            try {
                // get the user id
                userid = facebook.getId();
                
                // get the list of goals for the user
                FacebookDao dao = new MySQLFacebookDao();
                
                List<Goal> goals = dao.getAllGoal(userid);
                
                // check to see if any are overdue
                //Calendar calendar = Calendar.getInstance();
                //calendar.setTime(new Date());
                Date now = new Date();
                
                //System.out.println(calendar.toString());
                
                for (Goal goal : goals) {
                    System.out.println("you've got a goal");
                    System.out.println(goal.getDateAsDate());
                    //Calendar cal = goal.getCalendar();
                    //System.out.println(cal.getTime().toString() + " vs " + calendar.getTime().toString());
                    //if (calendar.compareTo(cal) >= 0) {
                    if (now.compareTo(goal.getDateAsDate()) >= 0) {
                        System.out.println("You have a failed goal");
                        try {
                            System.out.println("Failed goal text: " + goal.getFailString());
                            facebook.postStatusMessage(goal.getFailString()); 
                            //NOTE: if there is an identical post already, it will throw the exception.
                        } catch (FacebookException e) {
                            // you crashed when posting to facebook :(
                            e.printStackTrace();
                        }
                        dao.removeGoal(goal.getGoalId());
                    }
                }
                
                goals = dao.getAllGoal(userid);
                
                for (Goal goal : goals) {
                %>    
                <div class="list-group">
                    <div class="list-group-item">
                        <%= goal.getName() %> <br />
                        Due <%= goal.getDateString() %> <br />
                        <a class="btn btn-lg btn-success" onclick="deleteGoal( <%= goal.getGoalId() %>)">Goal Complete!</a>
                    </div>
                </div>
                <%
                }
                
                
                
                
                
            } catch (Exception ex) {
                
            }
            
        %>
        
    </body>
</html>
