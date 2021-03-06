<%-- 
    Document   : newGoal
    Created on : Jul 16, 2015, 11:32:24 AM
    Author     : Kevin Johnson (joh06018 at byui.edu)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create a Goal</title>
        
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

        <link rel="stylesheet" type="text/css" href="AccountabilityApp.css">

        <style>
            
            h1 {
                font-family: 'Cabin', sans-serif;
                text-align: left;
            }
            p {
                font-family: 'Cabin', sans-serif;
                font-size: 18px;
                text-align: left;
            }
            
            .container {
                text-align: left;
            }
        </style>

        <script>
            function validate() {
                // get the stuffs
                var form = document.forms["goalForm"];

                var name = form["name"].value;
                var failure = form["failure"].value;
                var endTime = form["endTime"].value;
                var endDate = form["endDate"].value;


                // make sure the name is filled in
                if (name === "") {
                    form["name"].focus();
                    return false;

                }

                // make sure the description is filled in
                if (failure === "") {
                    form["failure"].focus();
                    return false;
                }

                // check whether the time is after right now



                if (endDate === "") {
                    form["endDate"].focus();
                    return false;
                }
                if (endTime === "") {
                    form["endTime"].focus();
                    return false;
                }

                // this creates a date object set to the current time/date
                var today = new Date();


                // gather your variables!
                var inputYear = endDate.substring(0, 4);
                var inputMonth = parseInt(endDate.substring(5, 7)) - 1; // month is 0-11, not 1-12
                var inputDay = endDate.substring(8, 10);
                var inputHour = endTime.substring(0, 2);
                var inputMinutes = endTime.substring(3, 5);

                var inputDate = new Date(inputYear, inputMonth, inputDay, inputHour, inputMinutes);

                if (inputDate < today) {
                    form["endDate"].focus();
                    alert("The goal must be due in the future!");
                    return false;
                }

                // if you made it to this point, you're *probably* valid
                return true;
            }
        </script>
        
        <style>
            #labels { width: 175px;}
        </style>

    </head>
    <body>
        <div class="container">
        <h1>Add a new goal:</h1>
        <form name="goalForm" action="CreateGoal" method="POST" onSubmit="return validate()">
            <div class="input-group col-xs-6">
                <span id="labels" class="input-group-addon">Goal Name:</span>
                <input class="form-control" type="text" name="name" id="name" placeholder="What should we call the goal?" />
            </div>

            <div class="input-group col-xs-6">
                <span id="labels" class="input-group-addon">Goal Failure Message:</span>
                <input class="form-control" type="text" name="failure" id="failure" placeholder="What message will be posted?" />
            </div>

            <div class="input-group col-xs-4">
                <span id="labels" class="input-group-addon">Goal Ending Time:</span>
                <input class="form-control" type="time" name="endTime" id="endTime" />
            </div>

            <div class="input-group col-xs-4">
                <!-- <label for="endDate">Goal Ending Date:</label>-->
                <span id="labels" class="input-group-addon" >Goal Ending Date:</span>
                <input class="form-control" type="date" name="endDate" id="endDate" />
            </div>

            <p>
                <div class="container">
                    <button type="submit" value="Add Goal" class="btn btn-primary">Add Goal</button>
                </div>
            </p>
        </form>
        </div>


    </body>
</html>
