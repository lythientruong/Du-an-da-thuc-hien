<div id="header">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="http://localhost/doan3/"><h1>Trang chủ</h1></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0"> 
                            <div class="dropdown">
                        <button class="btn btn-primary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Tỉnh thành
                        </button>
                        <ul class="dropdown-menu"> 
                            
                            <?php 
                            // if($param=="nav"){
                            while($row = mysqli_fetch_array($data["province"])){?>
                            <li><a class="dropdown-item" href="getProduct_loai&id=<?php echo $row['idProvince']?>"><?php echo $row["nameProvince"]?></a>
                        </li>
                       <?php }?>                
                            <li><a class="dropdown-item" href="#">Dropdown item</a></li>
                            <li><a class="dropdown-item" href="#">Dropdown item</a></li>
                        </ul>
                        </div>
                            <div class="dropdown">
                        <button class="btn btn-primary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Số ngày 
                        </button>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="#">Dropdown item</a></li>
                            <li><a class="dropdown-item" href="#">Dropdown item</a></li>
                            <li><a class="dropdown-item" href="#">Dropdown item</a></li>
                        </ul>
                        </div>
                        </li>
                    </ul>
                    <form class="d-flex" action="search" method="post">
                        <input class="form-control me-2" type="search" name="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Tìm kiếm</button>
                    </form>
                    <form class="d-flex p-4" action="" method="post">
                    <button class="btn btn-outline-success" type="submit" name="giohang"><a href="http://localhost/doan3/home/xemgiohang">Thanh Toán</a></button>
                    </form>
                    <form class="d-flex p-3" action="../doan3/loginController/login" method="post">
                    <button class="btn btn-outline-success" type="submit" name="dangxuat">Đăng Nhập</button>
                    </form>
                </div>
            </div>
        </nav>
    </div>