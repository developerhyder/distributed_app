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
    if (isset($_GET["name"])) {
     $name = test_input($_GET["name"]);
     }
      if (isset($_GET["addr"])) {
     $addrs = test_input($_GET["addr"]);
     
     }
      if (isset($_GET["quan"])) {
     $quan = test_input($_GET["quan"]);
     
     }
      if (isset($_GET["ppu"])) {
     $ppu = test_input($_GET["ppu"]);
     
     }
      if (isset($_GET["date"])) {
     $date = test_input($_GET["date"]);
     
     }
     if (isset($_GET["pid"])) {
     $pid = test_input($_GET["pid"]);
     
     }
     $sq = "INSERT INTO `bc`(`name`, `address`, `quantity`, `ppu`, `date`,`pid`) VALUES ('$name','$addrs','$quan','$ppu','$date','$pid')";
            if (mysqli_query($conn, $sq)) {
                send_data($name,$addrs,$quan,$ppu,$date,$pid);
                echo "<p>New rec,ord created successfully</p>";
            } else {
                echo "<p>Error: " . $sq . "<br>" . mysqli_error($conn)."</p>";
        }
        $sql = "INSERT temp SELECT DISTINCT * FROM bc";
        $resul = mysqli_query($conn, $sql);
        $sql1 = "TRUNCATE TABLE bc";
        $resu = mysqli_query($conn,$sql1);
        $sql2 = "INSERT bc SELECT * FROM temp";
        $res = mysqli_query($conn,$sql2);
        $sql3 = "TRUNCATE TABLE temp";
        $re = mysqli_query($conn,$sql3);
        
function send_data($name,$addrs,$quan,$ppu,$date,$pid){
    //here we are sending the data to the other databases
    urlExists("https://developerhyder.000webhostapp.com/patent_db/reciever.php?name=$name&addr=$addrs&quan=$quan&ppu=$ppu&date=$date&pid=$pid");
}

    function urlExists($url=NULL)  
    {  
    if($url == NULL) return false;  
    $ch = curl_init($url);  
    curl_setopt($ch, CURLOPT_TIMEOUT, 5);  
    curl_setopt($ch, CURLOPT_CONNECTTIMEOUT, 5);  
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);  
    $data = curl_exec($ch);  
    $httpcode = curl_getinfo($ch, CURLINFO_HTTP_CODE);  
    curl_close($ch);  
    if($httpcode>=200 && $httpcode<300){  
         return true;  
    } else {  
          return false;  
        }  
    }   
    
    
mysqli_close($conn);
function test_input($data) {
        $data = trim($data);
        $data = stripslashes($data);
        $data = htmlspecialchars($data);
    return $data;
}
?>
