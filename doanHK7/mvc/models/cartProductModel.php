<?php
    class cartProductModel extends db{

        public function adminAddProduct($tensp,$giaban,$chitiet,$hinhanh,$soluong,$maloai,$math){
            $trangthaisp = '1';
            $noibat ='1';
            $qr = "INSERT INTO `sanpham`(`masp`, `tensp`, `giaban`, `chitiet`, `hinhanh`, `soluong`, `maloai`, `math`, `trangthaisp`, `noibat`) VALUES ('','$tensp','$giaban','$chitiet','$hinhanh','$soluong','$maloai','$math','$trangthaisp','$noibat')";
            //$qr = "INSERT INTO sanpham ('masp','tensp','giaban','chitiet','hinhanh','soluong','maloai','math','trangthaisp','noibat') VALUES ('','$tensp','$giaban','$chitiet','$hinhanh','$soluong','$maloai','$math','$trangthaisp','$noibat') ";
            mysqli_query($this->conn, $qr);
        }

        public function adminDelete($id){
            $qr = "DELETE FROM `sanpham` WHERE masp = '$id'";
            mysqli_query($this->conn, $qr);
        }


    }

?>