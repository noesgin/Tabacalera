<?php
    $con = mysqli_connect("mysql4.000webhost.com", "a5502689_admin", "tabacalera16", "a5502689_tabac");
    
    $username = $_POST["username"];
    $password = $_POST["password"];
    $statement = mysqli_prepare($con, "INSERT INTO User (username, password) VALUES (?, ?)");
    mysqli_stmt_bind_param($statement, "ss", $username, $password);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);
?>

