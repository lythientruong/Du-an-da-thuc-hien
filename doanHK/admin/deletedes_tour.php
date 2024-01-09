
<?php
session_start();
error_reporting(0);
include('includes/config.php');
if (strlen($_SESSION['alogin']) == 0) {
	header('location:index.php');
} else {
$pid=intval($_GET['pid']);
$sql = "DELETE from tblpackages_des where tblpackages_des.idpackdes=:pid";
$query = $dbh->prepare($sql);
$query -> bindParam(':pid', $pid, PDO::PARAM_STR);
$query->execute();
$results=$query->fetchAll(PDO::FETCH_OBJ);
	// $pid = intval($_GET['pid']);
	// 	$sql = "DELETE from tblpackages_des where tblpackages_des.idpackdes=:pid";
	// 	$query = $dbh->prepare($sql);
	// 	$query->execute();
	// 	$msg = "Xoá thành công";

} 
header('location:./adddestotour.php');
?>