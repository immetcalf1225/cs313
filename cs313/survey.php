<?php
session_start();

if (isset($_GET["Q1"]))
{
    $_SESSION["Q1"] = $_GET["Q1"];
    echo $_SESSION["Q1"] . "<br/>";
}

if (isset($_GET["Q2"]))
{
    $_SESSION["Q2"] = $_GET["Q2"];
    echo $_SESSION["Q2"] . "<br/>";
}

if (isset($_GET["Q3"]))
{
    $_SESSION["Q3"] = $_GET["Q3"];
    echo $_SESSION["Q3"] . "<br/>";
}

if (isset($_GET["Q4"]))
{
    $_SESSION["Q4"] = $_GET["Q4"];
    echo $_SESSION["Q4"] . "<br/>";
}

if (isset($_GET["Q5"]))
{
    $_SESSION["Q5"] = $_GET["Q5"];
    echo $_SESSION["Q5"] . "<br/>";
}

if (isset($_GET["Q6"]))
{
    $_SESSION["Q6"] = $_GET["Q6"];
    echo $_SESSION["Q6"] . "<br/>";
}

?>