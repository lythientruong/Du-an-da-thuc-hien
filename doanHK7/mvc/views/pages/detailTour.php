<?php
while ($row = mysqli_fetch_array($data["tour"])) {
?>
    <div class="container">
        <div class="row grid">
            <div class="col-sm-9 item-photo">
                <img style="max-width: 60%;" src='../public/images/<?php echo $row["img1"]; ?>' class='card-img-top' alt='...'>
            </div>
            <div class="col-sm-5" style="border:0px solid gray">
                <!-- Datos del vendedor y titulo del producto -->
                <h3><?php echo $row['titleTour']; ?> </h3>
                <!-- Precios -->
                <h6 class="title-price"><small>Giá bán</small></h6>
                <h3 style="margin-top:0px;"><?php echo $row['price']; ?> VND </h3>
                <!-- Detalles especificos del producto -->
                <div class="section" style="padding-bottom:20px;">
                    <h6 class="title-attr"><small>Số lượng</small></h6>
                    <div>
                        <div class="btn-minus"><span class="glyphicon glyphicon-minus"></span></div>
                        <input value="1" />
                        <div class="btn-plus"><span class="glyphicon glyphicon-plus"></span></div>
                    </div>
                </div>
                <!-- Botones de compra -->
                <div style="padding-bottom:20px;">
                    <button class='btn btn-primary col'>
                        <a style="text-decoration: none; Color:white" href='http://localhost/baocaoweb/home/addToCart&id=<?php echo $row["masp"]; ?>'>
                            Thêm vào giỏ
                        </a>
                    </button>
                </div>
            </div>

            <div class="col-xs-9">
                <h4>Thông tin sản phẩm</h4>
                <div style="width:100%;border-top:1px solid silver">
                    <p style="padding:15px;">
                        <?php echo  $row['chitiet']; ?>
                    </p>

                </div>
            </div>
        </div>
    </div>
<?php } ?>