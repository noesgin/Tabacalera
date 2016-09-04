<?php
	define('nombrehost', 'mysql4.000webhost.com');
	define('nombreuser', 'a5502689_admin');
	define('password', 'tabacalera16');
	define('nombrebd','a5502689_tabac');
	
	$con=mysqli_connect(nombrehost, nombreuser, password, nombrebd) or die ("no se ha podido conectar");
	$sql = "SELECT * FROM gallery";
	$result = mysqli_query($con, $sql);
	$json = array();
	
	if(mysqli_num_rows($result)){
		while($row=mysqli_fetch_object($result)){
			$json[]=$row;
		}
	}
    echo json_encode($json);
	mysqli_close($con);
?>