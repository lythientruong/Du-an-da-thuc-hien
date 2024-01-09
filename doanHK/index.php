<?php
session_start();
error_reporting(0);
include('includes/config.php');
?>
<!DOCTYPE HTML>
<html>

<head>
	<title>TMS | Hệ Thống Quản Lý Du Lịch</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<script type="applijewelleryion/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
	<link href="css/style.css" rel='stylesheet' type='text/css' />
	<link href="css/search.css" rel='stylesheet' type='text/css' />
	<link href='//fonts.googleapis.com/css?family=Open+Sans:400,700,600' rel='stylesheet' type='text/css'>
	<link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>
	<link href='//fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
	<link href="css/font-awesome.css" rel="stylesheet">
	<!-- Custom Theme files -->
	<script src="js/jquery-1.12.0.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<!--animate-->
	<link href="css/animate.css" rel="stylesheet" type="text/css" media="all">
	<script src="js/wow.min.js"></script>
	<script>
		new WOW().init();
	</script>
	<!--//end-animate-->
</head>

<body>
	<?php include('includes/header.php'); ?>
	<div class="banner">
		<div class="container">
			<h1 class="wow zoomIn animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: zoomIn;"> TMS - HỆ THỐNG QUẢN LÝ DU LỊCH</h1>
		</div>
	</div>

	<!--- rupes ---->
	<div class="container">
		<div class="rupes">
			<div class="col-md-4 rupes-left wow fadeInDown animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInDown;">
				<div class="rup-left">
					<a href="offers.html"><i class="fa fa-usd"></i></a>
				</div>
				<div class="rup-rgt">
					<h3> Giảm Giá Khủng đến 5%</h3>
					<h4>Du Lịch Tiết Kiệm</h4>

				</div>
				<div class="clearfix"></div>
			</div>
			<div class="col-md-4 rupes-left wow fadeInDown animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInDown;">
				<div class="rup-left">
					<a href="offers.html"><i class="fa fa-h-square"></i></a>
				</div>
				<div class="rup-rgt">
					<h3>Liên Kết Với Hơn 30% </h3>
					<h4>Khách Sạn Trên Cả Nước</h4>

				</div>
				<div class="clearfix"></div>
			</div>

			<div id="cover">
				<form method="get" action="index.php">
					<div class="tb">
						<div class="td"><input type="text" name="search" placeholder="Search" required></div>
						<div class="td" id="s-cover">
							<button type="submit">
								<div id="s-circle"></div>
								<span></span>
							</button>
						</div>
					</div>
				</form>
			</div>


		</div>
	</div>
	<!--- /rupes ---->

	<!---holiday---->
	<div class="container">
		<div class="holiday">
			<h3>Danh Sách Các Tour Phổ Biến</h3>
			<?php
			$sql = "SELECT * from tbltourpackages where tbltourpackages.action= 1 order by rand() limit 5";
			$query = $dbh->prepare($sql);
			$query->execute();
			$results = $query->fetchAll(PDO::FETCH_OBJ);
			$cnt = 1;
			if ($search = $_GET['search']) {
				$sql = "SELECT *FROM tbltourpackages WHERE tbltourpackages.PackageName LIKE'%$search%'";
				$query = $dbh->prepare($sql);
				$query->execute();
				$results = $query->fetchAll(PDO::FETCH_OBJ);
			}
			if ($query->rowCount() > 0) {
				foreach ($results as $result) {	?>
					<div class="rom-btm">
						<div class="col-md-3 room-left wow fadeInLeft animated" data-wow-delay=".5s">
							<a href="package-details.php?pkgid=<?php echo htmlentities($result->PackageId); ?>">
								<img src="admin/pacakgeimages/<?php echo htmlentities($result->PackageImage); ?>" class="img-responsive" alt="" style='border-radius: 10px;'>
							</a>
						</div>
						<div class="col-md-6 room-midle wow fadeInUp animated" data-wow-delay=".5s">
							<h2> <a href="package-details.php?pkgid=<?php echo htmlentities($result->PackageId); ?>"><?php echo htmlentities($result->PackageName); ?> </a></h2>
							<h6>Loại : <?php echo htmlentities($result->PackageType); ?></h6>
							<h6> Khởi hành từ : <?php echo htmlentities($result->PackageLocation); ?></h6>
							<h6>Phương tiện di chuyển: <?php echo htmlentities($result->PackageFetures); ?></h6>
						</div>
						<div class="col-md-3 room-right wow fadeInRight animated" data-wow-delay=".5s">
							<h3 style='color:#F50497'><?php echo htmlentities($result->PackagePrice); ?> đ</h3>
						</div>
						<div class="clearfix"></div>
					</div>

			<?php }
			} ?>


			<div><a href="package-list.php" class="view">Xem thêm tour</a></div>
		</div>
		<div class="clearfix"></div>
	</div>



	<!--- routes ---->
	<div class="routes">
		<div class="container">
			<div class="col-md-4 routes-left wow fadeInRight animated" data-wow-delay=".5s">
				<div class="rou-left">
					<a href="#"><i class="glyphicon glyphicon-list-alt"></i></a>
				</div>
				<div class="rou-rgt wow fadeInDown animated" data-wow-delay=".5s">
					<h3>80000</h3>
					<p>Enquiries</p>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="col-md-4 routes-left">
				<div class="rou-left">
					<a href="#"><i class="fa fa-user"></i></a>
				</div>
				<div class="rou-rgt">
					<h3>1900</h3>
					<p>Regestered users</p>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="col-md-4 routes-left wow fadeInRight animated" data-wow-delay=".5s">
				<div class="rou-left">
					<a href="#"><i class="fa fa-ticket"></i></a>
				</div>
				<div class="rou-rgt">
					<h3>7,00,00,000+</h3>
					<p>Booking</p>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>

	<?php include('includes/footer.php'); ?>
	<!-- signup -->
	<?php include('includes/signup.php'); ?>
	<!-- //signu -->
	<!-- signin -->
	<?php include('includes/signin.php'); ?>
	<!-- //signin -->
	<!-- write us -->
	<?php include('includes/write-us.php'); ?>
	<!-- //write us -->
</body>

</html>