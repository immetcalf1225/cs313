<%-- 
    Document   : welcome
    Created on : Jun 24, 2015, 4:30:03 PM
    Author     : isaacmetcalf
--%>

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


        <p>Unfinished goals will eventually be listed here</p>
    </body>
</html>
