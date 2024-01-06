<?php

    class tourModel extends db{
        public function getTour(){
            $qr = "SELECT * FROM tour";
            return mysqli_query($this->conn, $qr);
        }
        public function getdetailTour($id){
            $qr = "SELECT * FROM tour WHERE idTour = '$id' ";
            return mysqli_query($this->conn, $qr);
        }
        public function getProductforGiohang(){
            $id = $_SESSION['login']['matk'];
            $qr = "SELECT * FROM giohang WHERE matk = '$id'";
            return mysqli_query($this->conn, $qr);
        }
        public function getProduct_loai($loai){
            $qr = "SELECT * FROM sanpham WHERE Maloai = '$loai'";
            return mysqli_query($this->conn, $qr);
        }

        public function getProvince(){
            $qr = "SELECT * FROM province";
            echo"model nè";
            return mysqli_query($this->conn, $qr);
        }

        public function xoaspgiohang($id){
            $qr = "DELETE FROM `giohang` WHERE masp = '$id'";
            mysqli_query($this->conn, $qr);
        }
    

        public function search(){
            if(isset($_POST["search"]) && !empty($_POST["search"])){
                $key = $_POST["search"];
                $sql = "SELECT *FROM sanpham WHERE masp LIKE '%$key%' OR tensp LIKE '%$key%' OR maloai LIKE '%$key%'";
                $result = mysqli_query($this->conn, $sql);
                if(mysqli_num_rows($result)==0){
                    $sql = "SELECT * FROM sanpham";
                }
            }
            else{
                $sql = "SELECT * FROM sanpham";
            }
          
            return mysqli_query($this->conn, $sql);
        }

        public function xemdonhang(){
            $id = $_SESSION['login']['matk'];
            $qr = "SELECT * FROM donhang WHERE makh = '$id' ";
            return mysqli_query($this->conn, $qr);
            
        }

        public function addToCart($idsp, $tensp, $gia){
            $matk = $_SESSION['login']['matk'];
            $qr = "INSERT INTO `giohang`(`matk`, `masp`, `tensp`, `giaban`) VALUES ('$matk','$idsp','$tensp','$gia')";
            mysqli_query($this->conn, $qr);
        }

    }

?>