
<?php

session_start();
error_reporting(0);
include('includes/config.php');
if (strlen($_SESSION['alogin']) == 0) {
	header('location:index.php');
} else {
$pid=intval($_GET['pid']);
$sql = "UPDATE `tbltourpackages` SET `UpdationDate` = NULL, `action` = '0' WHERE `tbltourpackages`.`PackageId`=:pid";
$query = $dbh->prepare($sql);
$query -> bindParam(':pid', $pid, PDO::PARAM_STR);
$query->execute();
$results=$query->fetchAll(PDO::FETCH_OBJ);

} 
header('location:./manage-packages.php');
?>