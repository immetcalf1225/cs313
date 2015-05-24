<!DOCTYPE html>
<html>

<head>
    <title>Auctionicity</title>
    <link rel="stylesheet" type="text/css" href="auction_styles.css"/>
</head>
    
<body>
    <h3>Your Items</h3>
    <?php
        try
        {
            $user = 'dummy';
            $password = '77665';
            $db = new PDO("mysql:host=localhost; dbname=php_project_auction",$user,$password); 
        }
        catch (PDOException $ex)
        {
            echo 'Error!: ' . $ex->getMessage();
            die();
        }
        $db = new PDO("mysql:host=localhost;dbname=php_project_auction", 'dummy','77665');

        echo "<table style=100%; padding=10px>" .
             "<tr>".
             "<th>ID</th>" .
             "<th>Item Name</th>" .
             "<th>Start Date</th>" .
             "<th>Start Time</th>" .
             "<th>End Date</th>" .
             "<th>End Time</th>" .
             "<th>Starting Bid</th>" .
             "<th>Current Bid</th>" .
             "<th>Final Bid</th>";

        foreach ($db->query('SELECT * from items_for_sale') as $row)
        {
            echo   "<tr>" 
                 . "<td>" . $row['id']
                 . "<td>" . $row['item_name']
                 . "<td>" . $row['start_date']
                 . "<td>" . $row['start_time']
                 . "<td>" . $row['end_date']
                 . "<td>" . $row['end_time']
                 . "<td>" . "$" . $row['starting_bid']
                 . "<td>" . "$" . $row['current_bid']
                 . "<td>" . "$" . $row['final_bid']
                 . "</tr>";          
        }
        ?>
</body>
</html>