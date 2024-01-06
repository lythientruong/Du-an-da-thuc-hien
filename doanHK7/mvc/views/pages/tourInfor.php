<?php
while ($row = mysqli_fetch_array($data["tour"])) {
?>

    <div class='card' style='width: 18rem;'>
        <img src='./public/images/<?php echo $row["img1"];?>' class='card-img-top' alt='...'>
        <div class='card-body'>
            <h5 class='card-title'>
                <?php echo $row["titleTour"]; ?>
            </h5>
            <p class='card-text'>
                <?php echo $row["detail"]; ?>
            </p>
            <p class='card-text'>
                <?php echo $row["numberofdays"]; ?>
            </p>
            <div class='row'>
                <a href='http://localhost/doan3/home/addToCart&id=<?php echo $row["idTour"];?>' class='btn btn-primary col'>
                    Thêm vào giỏ
                </a>
                <a href='http://localhost/doan3/home/detailTour&id=<?php echo $row["idTour"];?>' class='btn btn-primary col'>
                    Xem chi tiết
                </a>
            </div>
        </div>

    </div>



<?php
}
?>