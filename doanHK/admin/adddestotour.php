<?php
session_start();
error_reporting(0);
include('includes/config.php');
if (strlen($_SESSION['alogin']) == 0) {
	header('location:index.php');
} else {
	if(isset($_POST['submit2']))
{
$fromdate=$_POST['tour'];
$todate=$_POST['des'];
$status=0;
$sql="INSERT INTO `tblpackages_des` (`idpackdes`, `pkgid`, `deid`) VALUES (NULL, :fromdate, :todate)";
$query = $dbh->prepare($sql);
$query->bindParam(':fromdate',$fromdate,PDO::PARAM_STR);
$query->bindParam(':todate',$todate,PDO::PARAM_STR);
$query->execute();
$lastInsertId = $dbh->lastInsertId();
if($lastInsertId)
{
	header('location:./adddestotour.php');
}

}
?>
	<!DOCTYPE HTML>
	<html>

	<head>
		<title>TMS | admin manage des
		</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script type="application/x-javascript">
			addEventListener("load", function() {
				setTimeout(hideURLbar, 0);
			}, false);

			function hideURLbar() {
				window.scrollTo(0, 1);
			}
		</script>
		<!-- Bootstrap Core CSS -->
		<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
		<!-- Custom CSS -->
		<link href="css/style.css" rel='stylesheet' type='text/css' />
		<link rel="stylesheet" href="css/morris.css" type="text/css" />
		<!-- Graph CSS -->
		<link href="css/font-awesome.css" rel="stylesheet">
		<!-- jQuery -->
		<script src="js/jquery-2.1.4.min.js"></script>
		<!-- //jQuery -->
		<!-- tables -->
		<link rel="stylesheet" type="text/css" href="css/table-style.css" />
		<link rel="stylesheet" type="text/css" href="css/basictable.css" />
		<script type="text/javascript" src="js/jquery.basictable.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$('#table').basictable();

				$('#table-breakpoint').basictable({
					breakpoint: 768
				});

				$('#table-swap-axis').basictable({
					swapAxis: true
				});

				$('#table-force-off').basictable({
					forceResponsive: false
				});

				$('#table-no-resize').basictable({
					noResize: true
				});

				$('#table-two-axis').basictable();

				$('#table-max-height').basictable({
					tableWrapper: true
				});
			});
		</script>
		<!-- //tables -->
		<link href='//fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400' rel='stylesheet' type='text/css' />
		<link href='//fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
		<!-- lined-icons -->
		<link rel="stylesheet" href="css/icon-font.min.css" type='text/css' />
		<!-- //lined-icons -->
	</head>

	<body>
		<div class="page-container">
			<!--/content-inner-->
			<div class="left-content">
				<div class="mother-grid-inner">
					<!--header start here-->
					<?php include('includes/header.php'); ?>
					<div class="clearfix"> </div>
				</div>
				<!--heder end here-->
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="./dashboard.php">Home</a><i class="fa fa-angle-right"></i>Quản lý địa điểm</li>
				</ol>
				<div class="agile-grids">
					<!-- tables -->

					<div class="agile-tables">
						<div class="w3l-table-info">
							<h2>Quản lý địa điểm</h2>
							<form name="book" method="post">
						<table>
							<tbody>
							<tr>
								<td>
								<label for="cars">Chọn Tour:</label>
										<select name="tour">
									<?php $sql = "SELECT tbltourpackages.PackageId, tbltourpackages.PackageName FROM `tbltourpackages` where tbltourpackages.action= 1 order by PackageName asc  ";
									$query = $dbh->prepare($sql);
									//$query -> bindParam(':city', $city, PDO::PARAM_STR);
									$query->execute();
									$results = $query->fetchAll(PDO::FETCH_OBJ);
									$cnt = 1;
									if ($query->rowCount() > 0) {
										foreach ($results as $result) {	?>
												
  													<option value="<?php echo htmlentities($result->PackageId); ?>"><?php echo htmlentities($result->PackageName); ?></option>
											<?php } }?>
										</select>
								</td>
							</tr>
							<tr>
								<td>
									<label for="cars">Chọn địa điểm</label>
									<select name="des">
									<?php $sql = "SELECT tbldes.desid, tbldes.desname FROM `tbldes` where tbldes.action= 1 order by desname asc  ";
									$query = $dbh->prepare($sql);
									//$query -> bindParam(':city', $city, PDO::PARAM_STR);
									$query->execute();
									$results = $query->fetchAll(PDO::FETCH_OBJ);
									if ($query->rowCount() > 0) {
										foreach ($results as $result) {	?>
												
  													<option value="<?php echo htmlentities($result->desid); ?>"><?php echo htmlentities($result->desname); ?></option>
											<?php } }?>
									</select>
								</td>
							</tr>
							</tbody>
						</table>	
						<button type="submit" name="submit2" class="btn-primary btn">Thêm địa điểm vào tour</button>			
					</form>
							<table id="table">
								<thead>
									<tr>
										<th>STT</th>
										<th>Tên tour</th>										
										<th>Tên địa điểm</th>
										<th>Chức năng</th>
									</tr>
								</thead>
								<tbody>
									<?php $sql = "SELECT tbltourpackages.PackageName, tbldes.desname, tblpackages_des.idpackdes
									FROM `tblpackages_des`,`tbltourpackages`,`tbldes` 
									WHERE tblpackages_des.pkgid=tbltourpackages.PackageId
									 AND tblpackages_des.deid=tbldes.desid ";
									$query = $dbh->prepare($sql);
									//$query -> bindParam(':city', $city, PDO::PARAM_STR);
									$query->execute();
									$results = $query->fetchAll(PDO::FETCH_OBJ);
									$cnt = 1;
									if ($query->rowCount() > 0) {
										foreach ($results as $result) {				?>
											<tr>
												<td><?php echo htmlentities($cnt); ?></td>
												<td><?php echo htmlentities($result->PackageName); ?></td>
												<td><?php echo htmlentities($result->desname ); ?></td>
												<td><a href="deletedes_tour.php?pid=<?php echo htmlentities($result->idpackdes); ?>"><button type="button" class="btn btn-primary btn-block">Xoá</button></a></td>
											</tr>
									<?php $cnt = $cnt + 1;
										}
									} ?>
								</tbody>
							</table>
						</div>
						</table>
					
					</div>
					
					<!-- script-for sticky-nav -->
					<script>
						$(document).ready(function() {
							var navoffeset = $(".header-main").offset().top;
							$(window).scroll(function() {
								var scrollpos = $(window).scrollTop();
								if (scrollpos >= navoffeset) {
									$(".header-main").addClass("fixed");
								} else {
									$(".header-main").removeClass("fixed");
								}
							});

						});
					</script>
					<!-- /script-for sticky-nav -->
					<!--inner block start here-->
					<div class="inner-block">

					</div>
					<!--inner block end here-->
					<!--copy rights start here-->
					<?php include('includes/footer.php'); ?>
					<!--COPY rights end here-->
				</div>
			</div>
			<!--//content-inner-->
			<!--/sidebar-menu-->
			<?php include('includes/sidebarmenu.php'); ?>
			<div class="clearfix"></div>
		</div>
		<script>
			var toggle = true;

			$(".sidebar-icon").click(function() {
				if (toggle) {
					$(".page-container").addClass("sidebar-collapsed").removeClass("sidebar-collapsed-back");
					$("#menu span").css({
						"position": "absolute"
					});
				} else {
					$(".page-container").removeClass("sidebar-collapsed").addClass("sidebar-collapsed-back");
					setTimeout(function() {
						$("#menu span").css({
							"position": "relative"
						});
					}, 400);
				}

				toggle = !toggle;
			});
		</script>
		<!--js -->
		<script src="js/jquery.nicescroll.js"></script>
		<script src="js/scripts.js"></script>
		<!-- Bootstrap Core JavaScript -->
		<script src="js/bootstrap.min.js"></script>
		<!-- /Bootstrap Core JavaScript -->

	</body>

	</html>
	<?php } ?>