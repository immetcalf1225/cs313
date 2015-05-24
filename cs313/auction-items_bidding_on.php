<!DOCTYPE html>
<html>

<head>
    <title>Auctionicity</title>
    <link rel="stylesheet" type="text/css" href="auction_styles.css"/>
</head>
    
<body>
    <h3>Your Bids</h3>
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
             "<th>Your Bid</th>" .
             "<th>Current High Bid</th>";

        foreach ($db->query('SELECT * from items_bidding_on') as $row)
        {
            echo   "<tr>" 
                 . "<td>" . $row['id']               . "&nbsp"
                 . "<td>" . $row['item_name']        . "&nbsp" 
                 . "<td>" . $row['start_date']       . "&nbsp"
                 . "<td>" . $row['start_time']       . "&nbsp" 
                 . "<td>" . $row['end_date']         . "&nbsp" 
                 . "<td>" . $row['end_time']         . "&nbsp" 
                 . "<td>" . "$" . $row['users_bid']        . "&nbsp" 
                 . "<td>" . "$" . $row['current_high_bid'] . "&nbsp" 
                 . "</tr>";          
        }
        ?>
</body>
</html>