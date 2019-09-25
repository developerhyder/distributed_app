<?php
$servername = "localhost";
$username = "*****_node2";
$password = "******";
$dbname="******_node2";

// Create connection
$conn = mysqli_connect($servername, $username, $password, $dbname);
// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}
if(isset($_GET['pid'])){
    $prod = test_input($_GET['pid']);
}
    $sql = "SELECT * FROM `bc` where pid = '$prod'";
    $result = mysqli_query($conn, $sql);
    if (mysqli_num_rows($result) > 0) {
        // looping through all results
        $response["apps"] = array();
        echo "<table>";
        $coun = 0;
        while ($row = mysqli_fetch_array($result)) {
        //the printing part
        $coun ++;
            echo "<tr><th>block number".$coun."</th><th>name:".$row['name']."</th><th>date: ".$row['date']."</th><th>address: ".$row['address']."</th><th>price per unit :".$row['ppu']."</th><th>quantity :".$row['quantity']."</th></tr>";
        }
        echo "</table>";
    }else{
        echo "No blocks have been created yet";
    }
     mysqli_close($conn);
function test_input($data) {
        $data = trim($data);
        $data = stripslashes($data);
        $data = htmlspecialchars($data);
    return $data;
}  
?>
